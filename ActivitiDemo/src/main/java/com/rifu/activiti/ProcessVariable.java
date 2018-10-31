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
 * ���̱���
 * @author Lifu
 *
 */
public class ProcessVariable {

	/**
	 * ��ȡĬ�ϵ����̣�Ĭ���Ǵ�activiti.cfg.xml�ж�ȡ������Ϣ
	 */
	private ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

	/**
	 * ���̵Ĳ���
	 */
	@Test
	public void testDeploy() {
		Deployment deployment = pe.getRepositoryService() // ��ȡ��service
				.createDeployment() // ��������
				.addClasspathResource("diagrams/StudentLeaveProcess.bpmn") // ���ؾ�̬��Դ
																	// .bpmn�ļ�
				.addClasspathResource("diagrams/StudentLeaveProcess.png") // ���ؾ�̬��Դ
																	// .bpmn�ļ���Ӧ��.png�ļ�
				.name("ѧ���������") // ������������
				.deploy();
		System.out.println("���̲���ID:" + deployment.getId());		//10001
		System.out.println("���̲���Name:" + deployment.getName());	
	}
	
	@Test
	public void start(){
		ProcessInstance pi = pe.getRuntimeService()
				.startProcessInstanceByKey("studentleaveProcess");
		System.out.println("����ʵ��id:" + pi.getProcessInstanceId());
		System.out.println("���̶���ID:" + pi.getProcessDefinitionId());
	}
	
	
	/**
	 * �����̱���������
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
		System.out.println("����ʵ��id:" + pi.getProcessInstanceId());
		System.out.println("���̶���ID:" + pi.getProcessDefinitionId());
	}
	
	/**
	 * ���̽�����ʱ�����ñ���
	 */
	@Test
	public void setVariablesWhenEndingProcess(){
		try {
			Map<String,Object> variables=new HashMap<String,Object>();
			variables.put("variable1", 1);
			variables.put("variable2","this is a string");
			variables.put("variable3",new Date());
			variables.put("student",new Student(1,"Rifu"));
			
			pe.getTaskService() // �������Service
					.complete("12504",variables); // ָ��Ҫ��ɵ�����ID
		} catch (Exception e) {
			System.out.println("This task is not exist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
	/**
	 * �鿴����
	 */
	@Test
	public void testFindProcess() {
		List<Task> tasks = pe.getTaskService().createTaskQuery().taskAssignee("lili") // ����ί��������������
				.list();
		for (Task t : tasks) {
			System.out.println("����ID:" + t.getId());
			System.out.println("�������ƣ�" + t.getName());
			System.out.println("���񴴽�ʱ�䣺" + t.getCreateTime());
			System.out.println("����ί���ˣ�" + t.getAssignee());
			System.out.println("����ʵ��ID:" + t.getProcessInstanceId());
		}
	}
	
	
	/**
	 * �������
	 */
	@Test
	public void finishProcess() {
		try {
			pe.getTaskService() // �������Service
					.complete("12504"); // ָ��Ҫ��ɵ�����ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
	/**
	 * �������̱�������
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
	 * ��ȡ���̱�������
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
	 * ͨ��Map�ķ�ʽΪtask�������̱���
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
	 * ͨ��Map�ķ�ʽ��ȡ���̱���
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
