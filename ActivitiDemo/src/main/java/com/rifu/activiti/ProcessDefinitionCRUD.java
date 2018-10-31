package com.rifu.activiti;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FileUtils;
import org.junit.Test;


/**
 * 流程定义的增删改查
 *      *不可以修改，会增加一个不同版本的流程定义*
 * @author Lifu
 *
 */
public class ProcessDefinitionCRUD {
	private ProcessEngine pe=ProcessEngines.getDefaultProcessEngine();
	
	@Test
	public void list(){
		String processDefinitionKey="myProcess";
		List<ProcessDefinition> pds=pe.getRepositoryService()
			.createProcessDefinitionQuery()
			.processDefinitionKey(processDefinitionKey)
			.list();
		
		for(ProcessDefinition pd:pds){
			 System.out.println("ID_："+pd.getId());
	        System.out.println("NAME_："+pd.getName());
	        System.out.println("KEY_："+pd.getKey());
	        System.out.println("VERSION_："+pd.getVersion());
	        System.out.println("===================");
		}
	}
	
	/**
	 * 通过ID查询流程定义
	 */
	@Test
	public void testGetProcessDefinitionById(){
		String processID="myProcess:2:7504";
		ProcessDefinition pd=pe.getRepositoryService()
			.createProcessDefinitionQuery()
			.processDefinitionId(processID)
			.singleResult();
		if(pd!=null){
			System.out.println("ID_："+pd.getId());
	        System.out.println("NAME_："+pd.getName());
	        System.out.println("KEY_："+pd.getKey());
	        System.out.println("VERSION_："+pd.getVersion());
	        System.out.println("===================");
		}
	}
	
	/**
	 * 根据部署ID(DEPLOYMENT_ID_)查询对应的流程图
	 */
	@Test
	public void getProcessImageById() throws Exception{
		InputStream is=pe.getRepositoryService()
			.getResourceAsStream("7501", "FirstProcess/FirstProcess.png");
		FileUtils.copyInputStreamToFile(is, new File("d:/test.png"));
	}
	
	@Test
	public void getProcessLastVersion(){
		//String processDefinitionKey="myProcess";
		List<ProcessDefinition> pds=pe.getRepositoryService()
			.createProcessDefinitionQuery()
			.orderByProcessDefinitionVersion().asc()
			//.processDefinitionKey(processDefinitionKey)
			.list();
		
		Map<String,ProcessDefinition> map=new LinkedHashMap<String,ProcessDefinition>();
		for(ProcessDefinition pd:pds){
			map.put(pd.getKey(), pd);
		}
		
		pds.clear();
		pds=new LinkedList<ProcessDefinition>(map.values());
		for(ProcessDefinition pd:pds){
			System.out.println("ID_："+pd.getId());
			System.out.println("NAME_："+pd.getName());
			System.out.println("KEY_："+pd.getKey());
			System.out.println("VERSION_："+pd.getVersion());
			System.out.println("===================");
		}
	}
	
	/**
	 * 根据部署ID删除流程定义(默认会进行级联删除)
	 */
	@Test
	public void deleteByDeploymentId(){
		/**
		 * 根据key 获取到部署ID
		 */
		String processDefinitionKey="myProcess";
		List<ProcessDefinition> pds=pe.getRepositoryService()
				.createProcessDefinitionQuery()
				.processDefinitionKey(processDefinitionKey)
				.list();
		
		for(ProcessDefinition pd:pds){
			pe.getRepositoryService()
				.deleteDeployment(pd.getDeploymentId(), true); 		//带参数true,进行级联删除
		}
	}
}
