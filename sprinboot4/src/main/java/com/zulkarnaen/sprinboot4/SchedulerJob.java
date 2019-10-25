package com.zulkarnaen.sprinboot4;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SchedulerJob extends QuartzJobBean {

	private ComplexQuartzScheduler anotherBean;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		anotherBean.printAnotherMessage();
	}

	public void setAnotherBean(ComplexQuartzScheduler anotherBean) {
		this.anotherBean = anotherBean;
	}
}
