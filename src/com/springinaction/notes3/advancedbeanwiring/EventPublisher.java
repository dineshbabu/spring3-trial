package com.springinaction.notes3.advancedbeanwiring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher extends ApplicationEvent implements ApplicationContextAware {

	private String message;
	
	private ApplicationContext applicationcontext;
	
	
	public EventPublisher(Object source, String message) {
		super(source);
		this.message = message;
		// TODO Auto-generated constructor stub
	}

	public String getMessage(){
		return message;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationcontext)
			throws BeansException {
		this.applicationcontext = applicationcontext;		
	}
	
	public void publishEvent(){
		System.out.println("publishing event");
		applicationcontext.publishEvent(new EventPublisher(this, message));
	}
}

@Component
class EventListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("event received");		
		if( event instanceof EventPublisher){
			System.out.println(((EventPublisher)event).getMessage());
		}
	}
	
}