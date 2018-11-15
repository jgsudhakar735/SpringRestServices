/**
 * 
 */
package com.jgsudhakar.microservices.rs.filter;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author sudhakar.t
 *
 */
@JsonFilter(value="Address")
public class Address {

	private Integer id;
	
	private String address1;
	
	private String address2;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(Integer id, String address1, String address2) {
		super();
		this.id = id;
		this.address1 = address1;
		this.address2 = address2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
}
