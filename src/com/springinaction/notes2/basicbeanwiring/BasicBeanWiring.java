
package com.springinaction.notes2.basicbeanwiring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicBeanWiring {
	  public static void main(String[] args) throws Exception {
		//ApplicationContext context = new FileSystemXmlApplicationContext("C:\\eclipseWorkspace\\zSpring\\src\\com\\springinaction\\chapter01\\hello\\hello.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext("hello1.xml");// hello1.xml should be in the class path , including in jars
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springinaction/notes2/basicbeanwiring/hello.xml");// hello.xml should be in the class path , including in jars
		
		GreetingService greetingService = (GreetingService) context.getBean("greetingService");
	    greetingService.sayGreeting();
	  } 
}

class GreetingServiceImpl implements GreetingService {
	
	private String greeting;
	private AnotherBean anotherBean;
	private String myProperty;
	private AnotherBean innerBean;
	
	@Inject
	private AutuDiscoverableBean autuDiscoverableBean;

	@Inject
	private AnotherBean javaConfiguredAnotherBean;
	
	@Inject
	private AutoWiredBean javaConfiguredAutoWiredBean;
	
	@Inject
	@Qualifier(value="autoWiredBean22")
	private AutoWiredBean injectedBean;
	
	@Autowired (required=true)
	@Qualifier(value="autoWiredBean11")
	private AutoWiredBean autoWiredBean;
	
	private Collection collection;
	
	/*@Autowired (required=true)
	public void setAutoWiredBean(AutoWiredBean autoWiredBean) {
		this.autoWiredBean = autoWiredBean;
	}*/

	private Set set;
	private Map map;
	private Properties properties;
	
	
	public GreetingServiceImpl() {}
	
	public GreetingServiceImpl(String greeting) {
	  this.greeting = greeting;
	  System.out.println("cons1 called"); 
	}
	
	public GreetingServiceImpl(String greeting, AnotherBean anotherBean) {
		  this.greeting = greeting;
		  this.anotherBean = anotherBean;
		  System.out.println("cons2 called");
	}
	
	/*@Inject
	private List<AnotherBean> getAutoWiredBeans(Provider<AnotherBean> awb	){
		List<AnotherBean> lst = new ArrayList<AnotherBean>();
		for (int i = 0; i < 3 ; i++) {
			lst.add(awb.get());	
		}
		return lst;
	}*/
	
	/*@Inject  
	@Named("autoWiredBean2")// uses bean ID rather and not qualifier as well as done by @Autowire 
	private List<AutoWiredBean> getAutoWiredBeans(Provider<AutoWiredBean> awb	){
		List<AutoWiredBean> lst = new ArrayList<AutoWiredBean>();
		for (int i = 0; i < 3 ; i++) {
			lst.add(awb.get());	
		}
		return lst;
	}*/
	
	public void setInnerBean(AnotherBean innerBean) {
		this.innerBean = innerBean;
	}
	
	public void sayGreeting() {
	   System.out.println(greeting);
	   System.out.println("anotherBean : " + anotherBean);
	   System.out.println( "innerBean : " + innerBean);
	   System.out.println("autoWiredBean : " + autoWiredBean);
	   System.out.println("injectedBean : " + autoWiredBean);
	   System.out.println("autuDiscoverableBean : " + autuDiscoverableBean);
	   System.out.println("javaConfiguredAnotherBean : " + javaConfiguredAnotherBean);
	   System.out.println("javaConfiguredAutoWiredBean : " + javaConfiguredAutoWiredBean);
	   
	   System.out.println(myProperty);
	   System.out.println(collection);
	   System.out.println(set);
	   System.out.println(map);
	   System.out.println(properties);
	}
	
	public void setMyProperty(String myProperty) {
		this.myProperty = myProperty;
	}
	
	public void setGreeting(String greeting) {
	  this.greeting = greeting;
	}
	
	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	
	public void setSet(Set set) {
		this.set = set;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	void init(){
		System.out.println("init method called");
	}
	
	void destroy(){
		System.out.println("destroy method called");
	}
	
}

interface GreetingService {
	  void sayGreeting();
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

