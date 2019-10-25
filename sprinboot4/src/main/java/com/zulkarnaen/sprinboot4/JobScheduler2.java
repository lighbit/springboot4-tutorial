package com.zulkarnaen.sprinboot4;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("jobScheduler2")
public class JobScheduler2 {

	public void printMessage2() {
		System.out.println("Iam Run Scheduler-2. in time " + new Date());
	}

}
