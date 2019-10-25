package com.zulkarnaen.sprinboot4;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("complexQuartzScheduler")
public class ComplexQuartzScheduler {
	
	public void printAnotherMessage(){
		System.out.println("Iam Run Scheduler Quarz Complex " + new Date());
	}
	
}
