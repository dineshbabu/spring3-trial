package com.springinaction.notes4.aop.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//@Component
@Aspect
public class GreetingAdvice{

	public GreetingAdvice() {}

	@Pointcut ("execution(* *.sayGreeting(..))")
	public void sayGreeting(boolean throwException) throws Exception {
	   
	}
	
	@Before("sayGreeting(..)")
	public void beforeMethodInvocation(){
		System.out.println("Calling before saying greeting");
	}
	
	@AfterReturning("sayGreeting(..)")
	public void afterReturningFromMethod(){
		System.out.println("Calling after returning saying greeting");
	}
	
	@AfterThrowing("sayGreeting(..)")
	public void afterThrowingOutOfMethod(){
		System.out.println("Calling after throwing saying greeting");
	}
	
	@Around("sayGreeting(..)")
	public void watchPerformance (ProceedingJoinPoint joinpoint) {
	  System.out.println("Around : Calling before saying greeting.");
	  try {
	    joinpoint.proceed();
	    System.out.println("Around: Calling after returning saying greeting");
	  } catch (Throwable throwable) {
		  System.out.println("Around: Calling after throwing saying greeting");
	  } 
	}
}



