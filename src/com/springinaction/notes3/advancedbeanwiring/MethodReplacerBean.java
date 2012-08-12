package com.springinaction.notes3.advancedbeanwiring;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class MethodReplacerBean implements MethodReplacer {

	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println("basic method replacement success");
		return null;
	}

}
