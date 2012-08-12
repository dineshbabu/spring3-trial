package com.springinaction.notes6a.webrequests;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

public class CommandController extends AbstractCommandController {

	public CommandController(){
		setCommandClass(User.class);
		setCommandName("user");
	}
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, 
			Object command, BindException errors) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
