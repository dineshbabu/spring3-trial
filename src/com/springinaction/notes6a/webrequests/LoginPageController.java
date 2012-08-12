package com.springinaction.notes6a.webrequests;

import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginPageController {	  

  //User user;
  
  @Inject
  private HibernateTemplate hibernateTemplate;
	
  public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
  }

  public LoginPageController() {
	  //user = new User();
  }
  
  @RequestMapping(value="/login",method=RequestMethod.GET)
  public String showLoginPage(Map<String, Object>model) {
	  return "login";
  }
  
  @RequestMapping(value="/authenticate",method=RequestMethod.POST)
  public String authentiacteUser(@RequestParam("username")  String username, @RequestParam("password")  String password, Model model ) {	  
	  
	  
	  /*List users = hibernateTemplate.find("select u from User u where username = ? and password = ?" , username, password);	 
	  if(users.size() == 1){
		  return "home";
	  }else{
		  return "loginFailed";
	  }*/
	  
	  User user = new User();
	  user.setEmail("myEmail");
	  user.setFirstName("firstName");
	  user.setLastName("lastName");
	  user.setUserName("userName");
	  
	  model.addAttribute("user", user);
	  
	  return "home";
  }
  
  @RequestMapping(value="/register",method=RequestMethod.POST)
  public String registerUser( @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {	  
	  
	  if(bindingResult.hasErrors()){
		  return "home";
	  }
	  /*List users = hibernateTemplate.find("select u from User u where username = ? and password = ?" , username, password);	 
	  if(users.size() == 1){
		  return "home";
	  }else{
		  return "loginFailed";
	  }*/
	  
	  return "users";
  }
  
}
