/**
 * 
 */
package com.jgsudhakar.microservices.rs.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

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
import com.jgsudhakar.microservices.rs.repository.UserRepository;
/**
 * @author sudhakar.t
 *
 */
@RestController
public class UserJPAController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/jpa/users")
	public List<User> findAllUsers (){
		return userRepository.findAll();
	}
	
	@GetMapping(path="/jpa/users/{id}")
	public Resource<User> findOne(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		Resource<User> resource = null;
		if(user.isPresent())
			resource = new Resource<User>(user.get());
		else
			throw new UserNotFoundException("User Not Found!");
		
		ControllerLinkBuilder builder = linkTo(methodOn(this.getClass()).findAllUsers());
		resource.add(builder.withRel("get-all-users"));
		return resource;
	}
	
	@PostMapping(path="/jpa/users")
	public void createUser (@Valid @RequestBody User user) {
		userRepository.save(user);
	}
	
	@DeleteMapping(path="/jpa/users/{id}")
	public User deletById(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
			userRepository.deleteById(id);
		else
			throw new UserNotFoundException("User Not Found!");
		
		return user.get();
	}
}
