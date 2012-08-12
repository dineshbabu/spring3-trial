package com.springinaction.notes5.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class EmployeeTest {
	
	/*private static JdbcTemplate jdbcTemplate;
	
	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		EmployeeTest.jdbcTemplate = jdbcTemplate;
	}*/
	
	private static NamedParameterJdbcTemplate jdbcTemplate;
	
	public static void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		EmployeeTest.jdbcTemplate = jdbcTemplate;
	}
	
	
	//private static final String INSERT_EMPLOYEE = "insert into employee values(employee_seq.nextval,?,?,?,?,?)";//non named paramater binding or JdbcTemplate
	
	private static final String INSERT_EMPLOYEE = "insert into employee values(employee_seq.nextval,:name,:salary,:manager,:deptId,:projectId)";//named paramater binding or NamedParameterJdbcTemplate
	
	

	private static void insertEmployee(){
		//jdbcTemplate.update(INSERT_EMPLOYEE, new Object[]{"DB", "7000", "N", "1", "1"}); // non named parameter or JdbcTemplate
		
		HashMap<String, String> parameter = new HashMap<String, String>();
		parameter.put("name", "DBABU");
		parameter.put("salary", "8000");
		parameter.put("manager", "N");
		parameter.put("deptId", "1");
		parameter.put("projectId", "1");
		
		//jdbcTemplate.update(INSERT_EMPLOYEE, parameter); // named parameter or NamedParameterJdbcTemplate
	}
	
	private static void getEmployees(){
		//non named parameter or JdbcTemplate 
		/*List<Employee> listEmployee = jdbcTemplate.query("select * from employee", new Object[]{} , new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
	            Employee employee = new Employee();
	            employee.setId(rs.getLong(1));
	            employee.setName(rs.getString(2));
	            employee.setSalary(rs.getInt(3));
	            employee.setManager(rs.getString(4));
	            employee.setDeptId(rs.getLong(5));
	            employee.setProjectId(rs.getLong(6));
	            return employee;
	          }
		});*/
		
		//named parameter or NamedParameterJdbcTemplate
		
		List<Employee> listEmployee = jdbcTemplate.query("select * from employee", Collections.EMPTY_MAP , new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException, DataAccessException {
	            Employee employee = new Employee();
	            employee.setId(rs.getLong(1));
	            employee.setName(rs.getString(2));
	            employee.setSalary(rs.getInt(3));
	            employee.setManager(rs.getString(4));
	            employee.setDeptId(rs.getLong(5));
	            employee.setProjectId(rs.getLong(6));
	            return employee;
	          }
		});
		
		for (Iterator iterator = listEmployee.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
		}
	
	}

	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/notes5/database/hello.xml");// hello.xml should be in the class path , including in jars
		
		EmployeeTest employee = (EmployeeTest) context.getBean("employeeTest");
		employee.insertEmployee();
		employee.getEmployees();
	}
}
