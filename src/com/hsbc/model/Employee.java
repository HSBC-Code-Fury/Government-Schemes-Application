/*
 * @Author Pratham Sharma
 * 
 * Class- Employee is a model/bean class used for accessing values of employee object
 * 
 * 	
 */
package com.hsbc.governmentschemes.model;

public class Employee {
	private String username,password;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "["+username+","+password+"]";
	}
	
	

}
