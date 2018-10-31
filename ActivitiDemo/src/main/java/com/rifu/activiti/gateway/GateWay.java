package com.rifu.activiti.gateway;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.rifu.model.Student;

/**
 * 网关:控制流程的走向
 * @author Lifu
 *
 */
public class GateWay {
	
	/**
	 * 获取默认的流程，默认是从activiti.cfg.xml中读取配置信息
	 */
	private ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

	/**
	 * 流程的部署
	 */
	@Test
	public void testDeploy() {
		Deployment deployment = pe.getRepositoryService() // 获取到service
				.createDeployment() // 创建部署
				.addClasspathResource("diagrams/StudentLeaveProcessWithControl.bpmn") // 加载静态资源
																	// .bpmn文件
				.addClasspathResource("diagrams/StudentLeaveProcessWithControl.png") // 加载静态资源
																	// .bpmn文件对应的.png文件
				.name("学生请假流程") // 设置流程名称
				.deploy();
		System.out.println("流程部署ID:" + deployment.getId());		//10001
		System.out.println("流程部署Name:" + deployment.getName());	
	}
	
	@Test
	public void start(){
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey("studentleaveProcess");
		System.out.println("流程实例id:" + pi.getProcessInstanceId());
		System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
	}
	
	/**
	 * 查看流程
	 */
	@Test
	public void testFindProcess() {
		List<Task> tasks = pe.getTaskService().createTaskQuery().taskAssignee("rifu") // 根据委派人来查找任务
				.list();
		for (Task t : tasks) {
			System.out.println("任务ID:" + t.getId());
			System.out.println("任务名称：" + t.getName());
			System.out.println("任务创建时间：" + t.getCreateTime());
			System.out.println("任务委派人：" + t.getAssignee());
			System.out.println("流程实例ID:" + t.getProcessInstanceId());
		}
	}
	
	
	/**
	 * 完成流程
	 */
	@Test
	public void finishProcess() {
		try {
			pe.getTaskService() // 任务相关Service
					.complete("32503"); // 指定要完成的任务ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
	/**
	 * 完成流程
	 */
	@Test
	public void finishProcessAndSetVariables() {
		try {
			Map<String,Object> variables=new HashMap<String,Object>();
			variables.put("duration", 4);
			
			pe.getTaskService() // 任务相关Service
					.complete("30002",variables); // 指定要完成的任务ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
}
