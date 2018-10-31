package com.rifu.activiti;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class ActivitiDemo {
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
				.addClasspathResource("diagrams/FirstProcess.bpmn") // ���ؾ�̬��Դ
																	// .bpmn�ļ�
				.addClasspathResource("diagrams/FirstProcess.png") // ���ؾ�̬��Դ
																	// .bpmn�ļ���Ӧ��.png�ļ�
				.name("rifuTask") // ������������
				.deploy();
		System.out.println("���̲���ID:" + deployment.getId());
		System.out.println("���̲���Name:" + deployment.getName());
	}

	/**
	 * �������̶��壬ʹ��zip�ķ�ʽ
	 */
	@Test
	public void testDeployByZip() {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("diagrams/FirstProcess.zip");
		ZipInputStream zipInputStream = new ZipInputStream(is);

		Deployment deployment = pe.getRepositoryService().createDeployment().addZipInputStream(zipInputStream)
				.name("ʹ��zip���������").deploy();

		System.out.println("���̲���ID:" + deployment.getId());
		System.out.println("���̲���Name:" + deployment.getName());
	}

	/**
	 * ���̵�����
	 */
	@Test
	public void testStartDeployment() {
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey("myProcess");
		System.out.println("����ʵ��id:" + pi.getProcessInstanceId());
		System.out.println("���̶���ID:" + pi.getProcessDefinitionId());
	}

	/**
	 * �鿴����
	 */
	@Test
	public void testFindProcess() {
		List<Task> tasks = pe.getTaskService().createTaskQuery().taskAssignee("rifu") // ����ί��������������
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
					.complete("2504"); // ָ��Ҫ��ɵ�����ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
		}
		System.out.println("This task has finished");
	}

	/**
	 * ��ѯ����״̬(����ִ��---ִ�н���)
	 */
	@Test
	public void checkProcessStatus() {
		ProcessInstance pi = pe.getRuntimeService().createProcessInstanceQuery().processInstanceId("12501").singleResult();
		if (pi != null) {
			System.out.println("��������ִ��");
		}else{
			System.out.println("����ִ�н���");
		}
	}
}
