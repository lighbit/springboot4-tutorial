package com.zulkarnaen.sprinboot4;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("simpleQuartzScheduler")
public class SimpleQuartzScheduler {

	public void printMessage() {
		System.out.println("Iam Run Scheduler Quarz Simple " + new Date());
	}
	
}
