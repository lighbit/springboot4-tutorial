package com.rest.zulkarnaen.springboot4.model;

import com.rest.zulkarnaen.springboot4.service.Encryption;
import com.rest.zulkarnaen.springboot4.service.Messaging;

public class Communication {

	private Messaging messaging;

	private Encryption encryption;

	/*
	 * DI via Constructor Injection
	 */
	public Communication(Encryption encryption) {
		this.encryption = encryption;
	}

	/*
	 * DI via Setter
	 */
	public void setMessaging(Messaging messaging) {
		this.messaging = messaging;
	}

	public void communicate() {
		encryption.encryptData();
		messaging.sendMessage();
	}

}
