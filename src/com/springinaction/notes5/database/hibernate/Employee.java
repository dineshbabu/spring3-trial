package com.springinaction.notes5.database.hibernate;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Employee extends JdbcDaoSupport {
	
	private long id;
	
	private String name;
	
	private int salary;
	
	private String manager;
	
	private long deptId;
	
	private long addrId;

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

	public long getAddrId() {
		return addrId;
	}

	public void setAddrId(long addrId) {
		this.addrId = addrId;
	}
	
	public String toString(){
		return "Id : "+ id +" Name : " + name + " salary : " + salary + " manager : "+ manager + " Dept Id :" + deptId + " Addr Id :" + addrId + "\n";
	}
}
