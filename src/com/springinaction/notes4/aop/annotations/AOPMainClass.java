
package com.springinaction.notes4.aop.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMainClass {
	  public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/notes4/aop/annotations/hello.xml");// hello.xml should be in the class path , including in jars
		
		GreetingService greetingService = (GreetingService) context.getBean("greetingServiceImpl");
	    greetingService.sayGreeting(false);
	    
	    greetingService.sayGreeting(true);
	  }
}

class GreetingServiceImpl implements GreetingService {

	public GreetingServiceImpl() {}

	public void sayGreeting( boolean throwException) throws Exception {
	   System.out.println("Greetings from Greetings service");
	   if(throwException){
		   throw new Exception("Exception thrown");
	   }
	}
}

interface GreetingService {	
	  public void sayGreeting(boolean throwException) throws Exception;
	  
	  
}


