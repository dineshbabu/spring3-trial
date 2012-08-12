package com.springinaction.notes2.basicbeanwiring;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Run BasicBeanWiring class which will make spring to load this class as well. Put a break point at SetValue() in 
 * setAsText in this class to see it working.
 * @author dbabu
 *
 */
public class MyCustomPropertyEditor extends PropertyEditorSupport {
	
	public void setAsText(String textValue) {
	    String stripped = textValue;
	    String areaCode = stripped.substring(0,3);
	    String prefix = stripped.substring(3,6);
	    String number = stripped.substring(6);
	    PhoneNumber phone = new PhoneNumber(areaCode, prefix, number);
	    setValue(phone);
	  }
}

@Component
class PhoneNumber {

	private String areaCode;
	
	private String prefix;
	
	private String number;

	public PhoneNumber() { }
	public PhoneNumber(String areaCode, String prefix,
                     String number) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.number = number;
  }
}

@Component
class Contact {
	
	@Value("111-222-333")// setting this string value to the PhoneNumber instance will trigger setAsText() in MyCustomPropertyEditor
	private PhoneNumber phoneNumber;
	public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
		}
}