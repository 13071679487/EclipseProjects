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
				.addClasspathResource("diagrams/FirstProcess.bpmn") // 加载静态资源
																	// .bpmn文件
				.addClasspathResource("diagrams/FirstProcess.png") // 加载静态资源
																	// .bpmn文件对应的.png文件
				.name("rifuTask") // 设置流程名称
				.deploy();
		System.out.println("流程部署ID:" + deployment.getId());
		System.out.println("流程部署Name:" + deployment.getName());
	}

	/**
	 * 部署流程定义，使用zip的方式
	 */
	@Test
	public void testDeployByZip() {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("diagrams/FirstProcess.zip");
		ZipInputStream zipInputStream = new ZipInputStream(is);

		Deployment deployment = pe.getRepositoryService().createDeployment().addZipInputStream(zipInputStream)
				.name("使用zip部署的流程").deploy();

		System.out.println("流程部署ID:" + deployment.getId());
		System.out.println("流程部署Name:" + deployment.getName());
	}

	/**
	 * 流程的启动
	 */
	@Test
	public void testStartDeployment() {
		ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey("myProcess");
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
					.complete("2504"); // 指定要完成的任务ID
		} catch (Exception e) {
			System.out.println("This task is not exeist");
		}
		System.out.println("This task has finished");
	}

	/**
	 * 查询流程状态(正在执行---执行结束)
	 */
	@Test
	public void checkProcessStatus() {
		ProcessInstance pi = pe.getRuntimeService().createProcessInstanceQuery().processInstanceId("12501").singleResult();
		if (pi != null) {
			System.out.println("流程正在执行");
		}else{
			System.out.println("流程执行结束");
		}
	}
}
