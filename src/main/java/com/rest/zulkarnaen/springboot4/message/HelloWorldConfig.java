package com.rest.zulkarnaen.springboot4.message;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.rest.zulkarnaen.springboot4.model.Communication;
import com.rest.zulkarnaen.springboot4.service.Encryption;
import com.rest.zulkarnaen.springboot4.service.HelloWorldservice;
import com.rest.zulkarnaen.springboot4.service.Messaging;
import com.rest.zulkarnaen.springboot4.serviceimpl.ActiveMQMessaging;
import com.rest.zulkarnaen.springboot4.serviceimpl.HelloWorldServiceImpl;
import com.rest.zulkarnaen.springboot4.serviceimpl.RSAEncryption;

@Configuration
public class HelloWorldConfig {

	@Bean(name = "helloWorldBean")
	@Description("This is a sample HelloWorld Bean")
	public HelloWorldservice helloWorld() {
		return new HelloWorldServiceImpl();
	}

	@Bean(name = "communication")
	public Communication communication() {
		Communication communication = new Communication(encryption());
		communication.setMessaging(messaging());
		return communication;
	}

	@Bean(name = "encryption")
	@Description("This bean will be injected via setter injection")
	public Encryption encryption() {
		return new RSAEncryption();
	}

	@Bean(name = "messaging")
	@Description("This bean will be injected via setter injection")
	public Messaging messaging() {
		return new ActiveMQMessaging();
	}

	/*
	 * TODO: @DESCRIPTION:
	 * 
	 * @Description adalah anotasi baru yang diperkenalkan di Spring 4 untuk
	 * memberikan deskripsi tekstual kacang yang dapat berguna untuk tujuan
	 * pemantauan. Dalam contoh khusus ini, tidak ada bedanya.
	 */

	/*
	 * TODO: ENCRYPTION AND MESSAGING Dalam konfigurasi di atas, kami menggunakan
	 * pendekatan Setter Properti untuk menyuntikkan bean ‘activeMqMessaging’ ke
	 * dalam properti ‘messaging’. Di sisi lain, kami menggunakan pendekatan
	 * Constructor Injection untuk menyuntikkan kacang 'rsaEncryption' ke dalam
	 * constructor Komunikasi.
	 */

}