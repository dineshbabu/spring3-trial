package com.springinaction.notes2.basicbeanwiring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {

	@Bean
	public AnotherBean javaConfiguredAnotherBean(){
		return new AnotherBean();
	}
	
	@Bean
	public AutoWiredBean javaConfiguredAutoWiredBean(){
		return new AutoWiredBean();
	}
}
