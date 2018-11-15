/**
 * 
 */
package com.jgsudhakar.microservices.rs.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author sudhakar.t
 *
 */
@RestController
public class FIlteringController {

	@GetMapping(path="/filtering")
	public MappingJacksonValue getAddress() {
		Address address =  new Address (1,"Pokkandala","Sydapuram");
		
		Set<String> exceptProperties = new HashSet<String>(Arrays.asList("address1","address2"));
		
		MappingJacksonValue jacksonValue = filterProperteries(address,"Address",exceptProperties);
		
		return jacksonValue;
		}

	@GetMapping(path="/filtering-list")
	public MappingJacksonValue getAddressList() {
		List<Address> address= new ArrayList<Address>(Arrays.asList(
				new Address(1,"Pokkandala","Sydapuram"),
				new Address(2,"Utukur","Sydapuram")
				)) ;
				Set<String> exceptProperties = new HashSet<String>(Arrays.asList("id","address2"));
		
				MappingJacksonValue jacksonValue = filterProperteries(address,"Address",exceptProperties);
				return jacksonValue;
	}

	private MappingJacksonValue filterProperteries(Object object,String filterName,Set<String> exceptProperties) {
		SimpleBeanPropertyFilter beanPropertyFilter = SimpleBeanPropertyFilter.
		filterOutAllExcept(exceptProperties);
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(filterName, beanPropertyFilter);
		
		MappingJacksonValue jacksonValue = new MappingJacksonValue(object);
		jacksonValue.setFilters(filterProvider);
		return jacksonValue;
	}
}
