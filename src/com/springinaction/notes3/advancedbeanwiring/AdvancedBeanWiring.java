
package com.springinaction.notes3.advancedbeanwiring;

import java.util.Locale;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvancedBeanWiring {
	  public static void main(String[] args) throws Exception {
		//ApplicationContext context = new FileSystemXmlApplicationContext("C:\\eclipseWorkspace\\zSpring\\src\\com\\springinaction\\chapter01\\hello\\hello.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("hello1.xml");// hello1.xml should be in the class path , including in jars
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/notes3/advancedbeanwiring/hello.xml");// hello.xml should be in the class path , including in jars
		
		GreetingService greetingService = (GreetingService) context.getBean("greetingService");
	    greetingService.sayGreeting();
	    greetingService.replaceThisMethodBasic();
	    
	    //Start i18n
	    Locale locale = Locale.ENGLISH; //determine locale
	    String text = context.getMessage("computer", new Object[0], locale);
	    System.out.println("i18n : " + text);
	    //End i18n
	    
	    //Start event publishing
	    EventPublisher eventPublisher = (EventPublisher)context.getBean("eventPublisher");
	    eventPublisher.publishEvent();
	    
	    //End event publishing
	    
	  }
}

class GreetingServiceImpl extends GreetingService {

	public GreetingServiceImpl() {}
	
	private String propertyFromParentAbstractBean;

	public void setPropertyFromParentAbstractBean(String propertyFromParentAbstractBean) {
		this.propertyFromParentAbstractBean = propertyFromParentAbstractBean;
	}

	public void setGreeting(String greeting){
		this.greeting = greeting;
	}

	public void sayGreeting() {
	   System.out.println(greeting);
	   System.out.println(propertyFromParentAbstractBean);
	}
	
	public void replaceThisMethodBasic(){
		System.out.println("replaceThisMethodBasic called");
	}
}

abstract class GreetingService {
	public String greeting = "Greetings from Greeting Service";
	  abstract void sayGreeting();
	  abstract void replaceThisMethodBasic();
}

class AnotherBean implements InitializingBean, DisposableBean{
	
	static AnotherBean init(){
		return new AnotherBean();
	}

	public void destroy() throws Exception {
		System.out.println("AnotherBean destroy called");
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("AnotherBean After property set called");
	}
	
	
}

