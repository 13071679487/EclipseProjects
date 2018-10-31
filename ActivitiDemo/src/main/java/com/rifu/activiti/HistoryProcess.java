package com.rifu.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.junit.Test;

/**
 * 历史流程的查询
 * 
 * @author Lifu
 *
 */
public class HistoryProcess {
	/**
	 * 获取默认的流程，默认是从activiti.cfg.xml中读取配置信息
	 */
	private ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();

	/**
	 * 历史任务列表查询
	 */
	@Test
	public void historyList() {
		List<HistoricTaskInstance> historics=pe.getHistoryService()
			.createHistoricTaskInstanceQuery()		//创建历史Task实例查询
			.processInstanceId("12501")  		//用流程实例ID查询
			.finished()
			.list();
		
		for(HistoricTaskInstance hti:historics){
			System.out.println("任务ID:"+hti.getId());
			System.out.println("流程实例ID:"+hti.getProcessInstanceId());
			System.out.println("任务名称："+hti.getName());
			System.out.println("委派人："+hti.getAssignee());
			System.out.println("开始时间："+hti.getStartTime());
			System.out.println("结束时间："+hti.getEndTime());
			System.out.println("==================");
		}
	}
	
	@Test
	public void historyActivitiInstanceList(){
		List<HistoricActivityInstance> hais=pe.getHistoryService()
			.createHistoricActivityInstanceQuery()		//创建历史活动实例查询
			.processInstanceId("12501")  		//用流程实例ID查询
			.finished()
			.list();
		
		for(HistoricActivityInstance hai:hais){
			System.out.println("任务ID:"+hai.getId());
			System.out.println("流程实例ID:"+hai.getProcessInstanceId());
			System.out.println("任务名称："+hai.getActivityName());
			System.out.println("委派人："+hai.getAssignee());
			System.out.println("开始时间："+hai.getStartTime());
			System.out.println("结束时间："+hai.getEndTime());
			System.out.println("==================");
		}
	}
	
	
}
