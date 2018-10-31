package com.rifu.activiti.taskassign;

import java.util.HashMap;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

/**
 * 个人的任务分配
 * 使用流程变量的方式设置Assignee
 * @author Lifu
 *
 */
public class PersonalTaskAssign {

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
				.addClasspathResource("diagrams/StudentLeaveProcessTaskAssign.bpmn") // 加载静态资源
																	// .bpmn文件
				.addClasspathResource("diagrams/StudentLeaveProcessTaskAssign.png") // 加载静态资源
																	// .bpmn文件对应的.png文件
				.name("学生请假流程个人任务分配") // 设置流程名称
				.deploy();
		System.out.println("流程部署ID:" + deployment.getId());		//10001
		System.out.println("流程部署Name:" + deployment.getName());	
	}
	
	
	/**
	 * 使用流程变量设置Assignee（任务执行者）
	 */
	@Test
	public void start(){
		HashMap<String, Object> variables = new HashMap<String,Object>();
		variables.put("userId", "3115002276");
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey("studentleaveProcessTaskassign",variables);
		System.out.println("流程实例id:" + pi.getProcessInstanceId());
		System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
	}
	
	
	
	/**
	 * 查看流程
	 */
	@Test
	public void testFindProcess() {
		List<Task> tasks = pe.getTaskService().createTaskQuery().taskAssignee("3115002276") // 根据委派人来查找任务
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
					.complete("92503"); // 指定要完成的任务ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
}
