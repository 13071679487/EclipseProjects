package com.rifu.test;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.rifu.bean.TestJob;

public class TestQuartz {
	
	public static void main(String[] args){
		try {
			testCronTrigger();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testCronTrigger() throws Exception{
		// 创建一个JobDetail实例，将该实例和Job.class绑定
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
				.withIdentity("myjob", "1")
				.usingJobData("msg", "this is a test message")
				.build();
		Date startDate=new Date();
		startDate.setTime(startDate.getTime()+3000);
		
		Date endDate=new Date();
		endDate.setTime(endDate.getTime()+9000);
		// 创建一个trigger实例
		CronTrigger trigger = (CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("trigger", "1")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("* * * * * ? *")
												)
				.build();
		//创建Scheduler实例，通过factory模式创建
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail,trigger); //返回值为Date，这个是最近将要执行的时间
		//scheduler.standby();		将当前scheduler挂起，并不是销毁，还可以重启
		//scheduler.shutdown();		将当前scheduler关闭，并销毁，
		//shutdown（boolean）传递参数为true时，等待当前正在执行的job完成后在进行shutdown,scheduler被shutdown之后，里面的job依然会执行
	}
	
	
	public static void testSimpleTrigger() throws Exception{
		// 创建一个JobDetail实例，将该实例和Job.class绑定
				JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
						.withIdentity("myjob", "1")
						.usingJobData("msg", "this is a test message")
						.build();
				Date startDate=new Date();
				startDate.setTime(startDate.getTime()+3000);
				
				Date endDate=new Date();
				endDate.setTime(endDate.getTime()+9000);
				// 创建一个trigger实例
				Trigger trigger = TriggerBuilder.newTrigger()
						.withIdentity("trigger", "1")
						.usingJobData("triggermsg","this is a trigger msg")
						.startAt(startDate)
						.endAt(endDate)
						.withSchedule(
								SimpleScheduleBuilder.simpleSchedule()
														.withIntervalInSeconds(2)
														.repeatForever()
														)
						.build();
				//创建Scheduler实例，通过factory模式创建
				SchedulerFactory factory = new StdSchedulerFactory();
				Scheduler scheduler = factory.getScheduler();
				scheduler.start();
				scheduler.scheduleJob(jobDetail,trigger);
	}
	
}
