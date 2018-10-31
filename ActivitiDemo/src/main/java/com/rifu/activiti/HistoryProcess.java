package com.rifu.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.junit.Test;

/**
 * ��ʷ���̵Ĳ�ѯ
 * 
 * @author Lifu
 *
 */
public class HistoryProcess {
	/**
	 * ��ȡĬ�ϵ����̣�Ĭ���Ǵ�activiti.cfg.xml�ж�ȡ������Ϣ
	 */
	private ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

	/**
	 * ��ʷ�����б��ѯ
	 */
	@Test
	public void historyList() {
		List<HistoricTaskInstance> historics=pe.getHistoryService()
			.createHistoricTaskInstanceQuery()		//������ʷTaskʵ����ѯ
			.processInstanceId("12501")  		//������ʵ��ID��ѯ
			.finished()
			.list();
		
		for(HistoricTaskInstance hti:historics){
			System.out.println("����ID:"+hti.getId());
			System.out.println("����ʵ��ID:"+hti.getProcessInstanceId());
			System.out.println("�������ƣ�"+hti.getName());
			System.out.println("ί���ˣ�"+hti.getAssignee());
			System.out.println("��ʼʱ�䣺"+hti.getStartTime());
			System.out.println("����ʱ�䣺"+hti.getEndTime());
			System.out.println("==================");
		}
	}
	
	@Test
	public void historyActivitiInstanceList(){
		List<HistoricActivityInstance> hais=pe.getHistoryService()
			.createHistoricActivityInstanceQuery()		//������ʷ�ʵ����ѯ
			.processInstanceId("12501")  		//������ʵ��ID��ѯ
			.finished()
			.list();
		
		for(HistoricActivityInstance hai:hais){
			System.out.println("����ID:"+hai.getId());
			System.out.println("����ʵ��ID:"+hai.getProcessInstanceId());
			System.out.println("�������ƣ�"+hai.getActivityName());
			System.out.println("ί���ˣ�"+hai.getAssignee());
			System.out.println("��ʼʱ�䣺"+hai.getStartTime());
			System.out.println("����ʱ�䣺"+hai.getEndTime());
			System.out.println("==================");
		}
	}
	
	
}
