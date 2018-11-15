/**
 * 
 */
package com.jgsudhakar.microservices.rs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.jgsudhakar.microservices.rs.exception.UserNotFoundException;
import com.jgsudhakar.microservices.rs.modal.User;

/**
 * @author sudhakar.t
 *
 */
@Component
public class UserDaoService {

	private static List<User> list = new ArrayList<>();
	private static AtomicInteger at = new AtomicInteger(1);
	static {
		list.add(new User(at.incrementAndGet(), "Sudhakar", new Date()));
		list.add(new User(at.incrementAndGet(), "Sailu", new Date()));
		list.add(new User(at.incrementAndGet(), "Sanvi", new Date()));
		list.add(new User(at.incrementAndGet(), "Sriyaan Sai", new Date()));
	}
	
	public List<User> findAll(){
		return list;
	}
	
	public User saveUser(User user) {
		user.setId(at.incrementAndGet());
		list.add(user);
		return user;
	}
	
	public User findById(Integer id) {
		 Optional<User> userData = list.stream().filter(user -> user.getId() == id).findFirst();
		 if(!userData.isPresent())
			 throw new UserNotFoundException("User Not Exist!");
		 return userData.get();
	}
	
	public User deleteById (Integer id) {
		Iterator<User> iterator = list.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if(user.getId() == id)
				iterator.remove();
			return user;
		}
		return null;
	}
}
