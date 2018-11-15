/**
 * 
 */
package com.jgsudhakar.microservices.rs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jgsudhakar.microservices.rs.exception.UserNotFoundException;
import com.jgsudhakar.microservices.rs.modal.User;
import com.jgsudhakar.microservices.rs.service.UserDaoService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * @author sudhakar.t
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping(path="/users")
	public List<User> findAllUsers (){
		return userDaoService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> findOne(@PathVariable Integer id) {
		User user = userDaoService.findById(id);
		
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder builder = linkTo(methodOn(this.getClass()).findAllUsers());
		resource.add(builder.withRel("get-all-users"));
		return resource;
	}
	
	@PostMapping(path="/users")
	public void createUser (@Valid @RequestBody User user) {
		userDaoService.saveUser(user);
	}
	
	@DeleteMapping(path="/users/{id}")
	public User deletById(@PathVariable Integer id) {
		User user =  userDaoService.deleteById(id);
		if(user == null)
			throw new UserNotFoundException("User Not Found!");
		return user;
	}
}
