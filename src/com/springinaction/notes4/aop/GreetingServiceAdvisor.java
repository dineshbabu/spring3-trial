package com.springinaction.notes4.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;



public class GreetingServiceAdvisor implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

	public GreetingServiceAdvisor(){
		
	}
	
	private GreetingServiceImpl greetingServiceImpl ;
	
	public void setGreetingServiceImpl(GreetingServiceImpl greetingServiceImpl) {
		this.greetingServiceImpl = greetingServiceImpl;
	}

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		greetingServiceImpl.afterReturningFromMethod();

	}

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		greetingServiceImpl.beforeMethodInvocation();

	}
	
	public void afterThrowing(Method method, Object[] args,
		    Object target, Exception e) {
		  greetingServiceImpl.afterThrowingOutOfMethod();
	}

}
