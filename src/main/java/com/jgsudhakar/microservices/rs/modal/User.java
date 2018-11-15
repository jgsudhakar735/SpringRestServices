/**
 * 
 */
package com.jgsudhakar.microservices.rs.modal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author sudhakar.t
 *
 */
@ApiModel(description= "All details about user")
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Null
	@Positive
	@Id
	@GeneratedValue
	private Integer id;
	
	
	@ApiModelProperty(notes="User Name Length should be min 5 and max 20!")
	@NotNull
	@Size(min=5, max=20,message="User Name Length should be min 5 and max 20!")
	private String name;
	
	@ApiModelProperty(notes="Birth Date should be past")
	@Past
	private Date birthDate;
	

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	
}
