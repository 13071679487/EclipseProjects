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
		// ����һ��JobDetailʵ��������ʵ����Job.class��
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
				.withIdentity("myjob", "1")
				.usingJobData("msg", "this is a test message")
				.build();
		Date startDate=new Date();
		startDate.setTime(startDate.getTime()+3000);
		
		Date endDate=new Date();
		endDate.setTime(endDate.getTime()+9000);
		// ����һ��triggerʵ��
		CronTrigger trigger = (CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("trigger", "1")
				.withSchedule(
						CronScheduleBuilder.cronSchedule("* * * * * ? *")
												)
				.build();
		//����Schedulerʵ����ͨ��factoryģʽ����
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail,trigger); //����ֵΪDate������������Ҫִ�е�ʱ��
		//scheduler.standby();		����ǰscheduler���𣬲��������٣�����������
		//scheduler.shutdown();		����ǰscheduler�رգ������٣�
		//shutdown��boolean�����ݲ���Ϊtrueʱ���ȴ���ǰ����ִ�е�job��ɺ��ڽ���shutdown,scheduler��shutdown֮�������job��Ȼ��ִ��
	}
	
	
	public static void testSimpleTrigger() throws Exception{
		// ����һ��JobDetailʵ��������ʵ����Job.class��
				JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
						.withIdentity("myjob", "1")
						.usingJobData("msg", "this is a test message")
						.build();
				Date startDate=new Date();
				startDate.setTime(startDate.getTime()+3000);
				
				Date endDate=new Date();
				endDate.setTime(endDate.getTime()+9000);
				// ����һ��triggerʵ��
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
				//����Schedulerʵ����ͨ��factoryģʽ����
				SchedulerFactory factory = new StdSchedulerFactory();
				Scheduler scheduler = factory.getScheduler();
				scheduler.start();
				scheduler.scheduleJob(jobDetail,trigger);
	}
	
}
