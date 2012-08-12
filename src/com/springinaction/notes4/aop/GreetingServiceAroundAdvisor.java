package com.springinaction.notes4.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingServiceAroundAdvisor implements MethodInterceptor{

	private GreetingServiceImpl greetingServiceImpl ;
	
	public void setGreetingServiceImpl(GreetingServiceImpl greetingServiceImpl) {
		this.greetingServiceImpl = greetingServiceImpl;
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		try{
			System.out.println("entering around advice");
			greetingServiceImpl.beforeMethodInvocation();
			Object returnValue = invocation.proceed(); 
			greetingServiceImpl.afterReturningFromMethod();
		}catch(Exception e){
			greetingServiceImpl.afterThrowingOutOfMethod();
		}
		
		return null;
	}

}
