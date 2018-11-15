/**
 * 
 */
package com.jgsudhakar.microservices.rs.controllers;

/**
 * @author sudhakar.t
 *
 */
public class HelloWorldBean {

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	private String message = "";

	public HelloWorldBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
