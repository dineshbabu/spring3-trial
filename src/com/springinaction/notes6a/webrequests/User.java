package com.springinaction.notes6a.webrequests;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	@Size(min=3,max=10,message="First name should be between 3 and 10 characters long")
	private String firstName;
	
	@Size(min=5,max=10,message="Lasst name should be between 5 and 10 characters long")
	private String lastName;
	
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",message="Invalid email address.")
	private String email;
	
	@Size(min=3,max=20,message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces.")
	private String userName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
