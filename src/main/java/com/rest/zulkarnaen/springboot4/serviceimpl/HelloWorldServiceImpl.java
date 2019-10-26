package com.rest.zulkarnaen.springboot4.serviceimpl;

import com.rest.zulkarnaen.springboot4.service.HelloWorldservice;

public class HelloWorldServiceImpl implements HelloWorldservice {

	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}

}
