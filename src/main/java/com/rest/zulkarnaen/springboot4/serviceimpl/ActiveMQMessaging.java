package com.rest.zulkarnaen.springboot4.serviceimpl;

import com.rest.zulkarnaen.springboot4.service.Messaging;

public class ActiveMQMessaging implements Messaging {

	public void sendMessage() {
		System.out.println("Sending Message via Active MQ");
	}
}