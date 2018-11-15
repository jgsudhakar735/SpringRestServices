/**
 * 
 */
package com.jgsudhakar.microservices.rs.filter;

/**
 * @author sudhakar.t
 *
 */
public class AddressV1 {

	private Integer id;
	
	private String address1;
	
	private String address2;
	
	public AddressV1() {
		// TODO Auto-generated constructor stub
	}

	public AddressV1(Integer id, String address1, String address2) {
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
