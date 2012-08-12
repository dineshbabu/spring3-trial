package com.springinaction.notes5.database;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Employee extends JdbcDaoSupport {
	
	private long id;
	
	private String name;
	
	private int salary;
	
	private String manager;
	
	private long deptId;
	
	private long projectId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public String toString(){
		return "Id : "+ id +" Name : " + name + " salary : " + salary + " manager : "+ manager + " Dept Id :" + deptId + " Project Id :" + projectId + "\n";
	}
}
