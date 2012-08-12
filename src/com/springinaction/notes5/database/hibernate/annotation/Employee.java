package com.springinaction.notes5.database.hibernate.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private long id;
	
	@Column
	private String name;
	
	@Column
	private int salary;
	
	@Column
	private String manager;
	
	@Column(name="dept_id")
	private long deptId;
	
	@Column(name="addr_id")
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
