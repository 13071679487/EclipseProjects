package com.rifu.activiti.gateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;


/**
 * ����:�������̵�����
 * ExclusiveGateWay
 * ��������:����ӿڶ�����Ż�ִ����һ��
 * @author Lifu
 *
 */
public class ParallelGateWay {
	
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
				.addClasspathResource("diagrams/StudentLeaveProcessWithControl3.bpmn") // ���ؾ�̬��Դ
																	// .bpmn�ļ�
				.addClasspathResource("diagrams/StudentLeaveProcessWithControl3.png") // ���ؾ�̬��Դ
																	// .bpmn�ļ���Ӧ��.png�ļ�
				.name("ѧ��������̲�������") // ������������
				.deploy();
		System.out.println("���̲���ID:" + deployment.getId());		//10001
		System.out.println("���̲���Name:" + deployment.getName());	
	}
	
	@Test
	public void start(){
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey("studentleaveProcessWithGateway3");
		System.out.println("����ʵ��id:" + pi.getProcessInstanceId());
		System.out.println("���̶���ID:" + pi.getProcessDefinitionId());
	}
	
	/**
	 * �鿴����
	 */
	@Test
	public void testFindProcess() {
		List<Task> tasks = pe.getTaskService().createTaskQuery().processDefinitionName("У������") // ����ί��������������
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
					.complete("92503"); // ָ��Ҫ��ɵ�����ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
	/**
	 * �������
	 */
	@Test
	public void finishProcessAndSetVariables() {
		try {
			Map<String,Object> variables=new HashMap<String,Object>();
			variables.put("duration", 15);
			
			pe.getTaskService() // �������Service
					.complete("77504",variables); // ָ��Ҫ��ɵ�����ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
			e.printStackTrace();
		}
		System.out.println("This task has finished");
	}
	
}
