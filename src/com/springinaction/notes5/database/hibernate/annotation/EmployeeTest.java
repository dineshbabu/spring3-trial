package com.springinaction.notes5.database.hibernate.annotation;

/**
 * Does not work . java.lang.NoSuchMethodError: org.hibernate.SessionFactory.openSession()Lorg/hibernate/classic/Session;
 * . COuld not see any call to openSession() that returns org/hibernate/classic/Session, but only org/hibernate/Session.
 * Not sure why and how the exception is thrown. WEIRD
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeTest {
	
	public EmployeeTest(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	private static SessionFactory sessionFactory;
	
	private static HibernateTemplate hibernateTemplate;
	
    public static void main(String[] args) {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/notes5/database/hibernate/annotation/hello.xml");// hello.xml should be in the class path , including in jars
		
		EmployeeTest employee = (EmployeeTest) context.getBean("employeeTest");
		
		insertEmployee();
		
		System.out.println(getEmployees());
      }
    
    private static List<Employee> getEmployees(){
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
		
		List<Employee> listEmployee = hibernateTemplate.find("select e from Employee e");
		return listEmployee;
    }
    
    private static void insertEmployee(){
		hibernateTemplate.saveOrUpdate(getNewEmployee());
	}
	
    
    private static Employee getNewEmployee(){
    	 Employee employee = new Employee();
    	 employee.setName("DBA");
    	 employee.setSalary(1000);
    	 employee.setManager("N");
    	 employee.setDeptId(1);
    	 employee.setAddrId(1);
    	 return employee;
    }

	public static void setSessionFactory(SessionFactory sessionFactory) {
		EmployeeTest.sessionFactory = sessionFactory;
	}

	/*public static void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		EmployeeTest.hibernateTemplate = hibernateTemplate;
	}*/
  }