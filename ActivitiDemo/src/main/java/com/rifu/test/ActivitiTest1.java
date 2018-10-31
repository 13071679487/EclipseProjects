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
		 * false	�����Զ�������
		 * create-drop	��ɾ�����ٴ�����
		 * true		�Զ������͸��±�
		 */
		pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		
		ProcessEngine pe = pec.buildProcessEngine();
	}
	
	/**
	 * ͨ��xml���ñ�ķ�ʽ��������������
	 */
	@Test
	public void testCreateTableWithXML(){
		ProcessEngineConfiguration pec = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine pe = pec.buildProcessEngine();
	}
}
