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
 * ���̶������ɾ�Ĳ�
 *      *�������޸ģ�������һ����ͬ�汾�����̶���*
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
			 System.out.println("ID_��"+pd.getId());
	        System.out.println("NAME_��"+pd.getName());
	        System.out.println("KEY_��"+pd.getKey());
	        System.out.println("VERSION_��"+pd.getVersion());
	        System.out.println("===================");
		}
	}
	
	/**
	 * ͨ��ID��ѯ���̶���
	 */
	@Test
	public void testGetProcessDefinitionById(){
		String processID="myProcess:2:7504";
		ProcessDefinition pd=pe.getRepositoryService()
			.createProcessDefinitionQuery()
			.processDefinitionId(processID)
			.singleResult();
		if(pd!=null){
			System.out.println("ID_��"+pd.getId());
	        System.out.println("NAME_��"+pd.getName());
	        System.out.println("KEY_��"+pd.getKey());
	        System.out.println("VERSION_��"+pd.getVersion());
	        System.out.println("===================");
		}
	}
	
	/**
	 * ���ݲ���ID(DEPLOYMENT_ID_)��ѯ��Ӧ������ͼ
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
			System.out.println("ID_��"+pd.getId());
			System.out.println("NAME_��"+pd.getName());
			System.out.println("KEY_��"+pd.getKey());
			System.out.println("VERSION_��"+pd.getVersion());
			System.out.println("===================");
		}
	}
	
	/**
	 * ���ݲ���IDɾ�����̶���(Ĭ�ϻ���м���ɾ��)
	 */
	@Test
	public void deleteByDeploymentId(){
		/**
		 * ����key ��ȡ������ID
		 */
		String processDefinitionKey="myProcess";
		List<ProcessDefinition> pds=pe.getRepositoryService()
				.createProcessDefinitionQuery()
				.processDefinitionKey(processDefinitionKey)
				.list();
		
		for(ProcessDefinition pd:pds){
			pe.getRepositoryService()
				.deleteDeployment(pd.getDeploymentId(), true); 		//������true,���м���ɾ��
		}
	}
}
