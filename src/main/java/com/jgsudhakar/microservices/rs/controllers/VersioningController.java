/**
 * 
 */
package com.jgsudhakar.microservices.rs.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jgsudhakar.microservices.rs.filter.AddressV1;
import com.jgsudhakar.microservices.rs.modal.User;
import com.jgsudhakar.microservices.rs.modal.UserV1;
import com.jgsudhakar.microservices.rs.service.UserDaoService;

/**
 * @author sudhakar.t
 *
 */
@RestController
public class VersioningController {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping(value="/v1/users/params",params="version=1")
	public List<UserV1> findAllUsers (){
		AddressV1 address = new AddressV1();
		address.setAddress1("Pokkandala");
		address.setAddress2("Sydapuram");
		address.setId(1);
		return new ArrayList<UserV1>(
				Arrays.asList(
						new UserV1(1,"Sudhakar",new Date(),address),
						new UserV1(2,"Sailu",new Date(),address),
						new UserV1(3,"Sanvi",new Date(),address),
						new UserV1(4,"SriyaanSai",new Date(),address)
						)
				);
	}

	@GetMapping(value="/v1/users/params",params="version=2")
	public List<UserV1> findAllUsers1 (){
		AddressV1 address = new AddressV1();
		address.setAddress1("Pokkandala");
		address.setAddress2("Sydapuram");
		address.setId(1);
		return new ArrayList<UserV1>(
				Arrays.asList(
						new UserV1(2,"Sailu",new Date(),address),
						new UserV1(3,"Sanvi",new Date(),address),
						new UserV1(4,"SriyaanSai",new Date(),address)
						)
				);
	}
	
	@GetMapping(path="/v1//users/{id}")
	public Resource<User> findOne(@PathVariable Integer id) {
		User user = userDaoService.findById(id);
		
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder builder = linkTo(methodOn(this.getClass()).findAllUsers());
		resource.add(builder.withRel("get-all-users"));
		return resource;
	}
}
