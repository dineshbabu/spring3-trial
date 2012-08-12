package com.springinaction.notes2.basicbeanwiring;


class AutoWiredBean {
	public AutoWiredBean() {
		System.out.println("inside auto wired bean constructor");
	}
}

class AutoWiredBeanSubClass1 extends AutoWiredBean{
	
}

class AutoWiredBeanSubClass2 extends AutoWiredBean{
	
}