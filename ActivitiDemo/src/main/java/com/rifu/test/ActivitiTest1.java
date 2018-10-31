package com.rifu.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class ActivitiTest1 {

	@Test
	public void testCreateTable(){
		ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		pec.setJdbcDriver("com.mysql.jdbc.Driver");
		pec.setJdbcUrl("jdbc:mysql://localhost:3306/activiti");
		pec.setJdbcUsername("root");
		pec.setJdbcPassword("528428");
		
		/**
		 * false	不能自动创建表
		 * create-drop	先删除表再创建表
		 * true		自动创建和更新表
		 */
		pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
		ProcessEngine pe = pec.buildProcessEngine();
	}
	
	/**
	 * 通过xml配置表的方式来创建流程引擎
	 */
	@Test
	public void testCreateTableWithXML(){
		ProcessEngineConfiguration pec = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine pe = pec.buildProcessEngine();
	}
}
