package com.springinaction.notes6a.webrequests.persitence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Login")
public class User {
	
	@Id
	private long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	private String email;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString(){
		return "Id : "+ id +" first Name : " + firstName + " Last Name : " + lastName + " username : "+ username + " email :" + email + "\n";
	}
}
