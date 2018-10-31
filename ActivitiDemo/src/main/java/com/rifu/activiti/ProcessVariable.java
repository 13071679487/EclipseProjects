package com.rifu.activiti;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.rifu.model.Student;

/**
 * 流程变量
 * @author Lifu
 *
 */
public class ProcessVariable {

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
				.addClasspathResource("diagrams/StudentLeaveProcess.bpmn") // 加载静态资源
																	// .bpmn文件
				.addClasspathResource("diagrams/StudentLeaveProcess.png") // 加载静态资源
																	// .bpmn文件对应的.png文件
				.name("学生请假流程") // 设置流程名称
				.deploy();
		System.out.println("流程部署ID:" + deployment.getId());		//10001
		System.out.println("流程部署Name:" + deployment.getName());	
	}
	
	@Test
	public void start(){
		ProcessInstance pi = pe.getRuntimeService()
				.startProcessInstanceByKey("studentleaveProcess");
		System.out.println("流程实例id:" + pi.getProcessInstanceId());
		System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
	}
	
	
	/**
	 * 带流程变量的启动
	 */
	@Test
	public void startWithVariables(){
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("variable1", 1);
		variables.put("variable2","this is a string");
		variables.put("variable3",new Date());
		variables.put("student",new Student(1,"Rifu"));
		ProcessInstance pi = pe.getRuntimeService()
				.startProcessInstanceByKey("studentleaveProcess", variables);
		System.out.println("流程实例id:" + pi.getProcessInstanceId());
		System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
	}
	
	/**
	 * 流程结束的时候设置变量
	 */
	@Test
	public void setVariablesWhenEndingProcess(){
		try {
			Map<String,Object> variables=new HashMap<String,Object>();
			variables.put("variable1", 1);
			variables.put("variable2","this is a string");
			variables.put("variable3",new Date());
			variables.put("student",new Student(1,"Rifu"));
			
			pe.getTaskService() // 任务相关Service
					.complete("12504",variables); // 指定要完成的任务ID
		} catch (Exception e) {
			System.out.println("This task is not exist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
	/**
	 * 查看流程
	 */
	@Test
	public void testFindProcess() {
		List<Task> tasks = pe.getTaskService().createTaskQuery().taskAssignee("lili") // 根据委派人来查找任务
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
					.complete("12504"); // 指定要完成的任务ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
	/**
	 * 设置流程变量数据
	 */
	@Test
	public void setVariable(){
		TaskService taskService = pe.getTaskService();
		String taskID="15002";
		taskService.setVariable(taskID, "variable1",1);
		taskService.setVariable(taskID, "variable2","this is a string");
		taskService.setVariable(taskID, "variable3",new Date());
		taskService.setVariable(taskID, "student",new Student(1,"Rifu"));
		System.out.println("setVariable success!");
	}
	
	/**
	 * 获取流程变量数据
	 */
	@Test
	public void getVariable(){
		String taskID="22510";
		TaskService taskService = pe.getTaskService();
		int variable1 = (Integer)taskService.getVariable(taskID, "variable1");
		String variable2=(String)taskService.getVariable(taskID, "variable2");
		Date variable3=(Date)taskService.getVariable(taskID, "variable3");
		System.out.println(variable1);
		System.out.println(variable2);
		System.out.println(variable3);
		Student stu=(Student)taskService.getVariable(taskID, "student");
		System.out.println(stu);
	}
	
	/**
	 * 通过Map的方式为task设置流程变量
	 */
	@Test
	public void setVariableByMap(){
		TaskService taskService = pe.getTaskService();
		String taskID="15002";
		
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("variable1", 1);
		variables.put("variable2","this is a string");
		variables.put("variable3",new Date());
		variables.put("student",new Student(1,"Rifu"));
		taskService.setVariables(taskID, variables);
		System.out.println("setVariable success!");
	}
	
	/**
	 * 通过Map的方式获取流程变量
	 */
	@Test
	public void getVariableByMap(){
		String taskID="15002";
		TaskService taskService = pe.getTaskService();
		Map<String, Object> variables = taskService.getVariables(taskID);
		
		int variable1 = (Integer)variables.get( "variable1");
		String variable2=(String)variables.get("variable2");
		Date variable3=(Date)variables.get("variable3");
		System.out.println(variable1);
		System.out.println(variable2);
		System.out.println(variable3);
		Student stu=(Student)variables.get("student");
		System.out.println(stu);
	}
}
