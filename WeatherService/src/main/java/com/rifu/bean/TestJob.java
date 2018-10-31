package com.rifu.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class TestJob implements Job{
	
	private String msg;
	

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public void execute(JobExecutionContext context) throws JobExecutionException {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("currentTime is :"+sdf.format(date));
		//编写具体的业务 逻辑
		
		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("Job name and group are:"+jobKey.getName()+"--"+jobKey.getGroup());
		
		TriggerKey triggerKey = context.getTrigger().getKey();
		System.out.println("trigger name and group are:"+triggerKey.getName()+"--"+triggerKey.getGroup());
		
		/**
		 * 获取datamap
		 */
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		JobDataMap triggerDataMap = context.getTrigger().getJobDataMap();
		context.getMergedJobDataMap();
		String msg=jobDataMap.getString("msg"); 
		System.out.println("msg:"+msg);
		
	}

}
