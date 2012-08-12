package com.springinaction.notes3.advancedbeanwiring;

/**
 * Run AdvancedBeanWiring and put a break point in the constructor of this class
 * @author dbabu
 *
 */
public class ExternaliseProperty {

	private String jdbc_url;
	private String jdbc_user_name;
	private String jdbc_password;
	private String jdbc_database;
	
	public  ExternaliseProperty(){}
	
	public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}

	public void setJdbc_user_name(String jdbc_user_name) {
		this.jdbc_user_name = jdbc_user_name;
	}

	public void setJdbc_password(String jdbc_password) {
		this.jdbc_password = jdbc_password;
	}

	public void setJdbc_database(String jdbc_database) {
		this.jdbc_database = jdbc_database;
	}

	public ExternaliseProperty(String jdbc_database, String jdbc_password, String jdbc_url, String jdbc_user_name){
		this.jdbc_database = jdbc_database;
		this.jdbc_password = jdbc_password;
		this.jdbc_url = jdbc_url;
		this.jdbc_user_name = jdbc_user_name;
	}
	
	
}
