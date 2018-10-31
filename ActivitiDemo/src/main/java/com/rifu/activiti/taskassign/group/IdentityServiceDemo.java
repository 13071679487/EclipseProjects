package com.rifu.activiti.taskassign.group;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.junit.Test;

public class IdentityServiceDemo {
	/**
	 * 获取默认的流程，默认是从activiti.cfg.xml中读取配置信息
	 */
	private ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
	IdentityService identityService = pe.getIdentityService();

	@Test
	public void testSaveUser() {
		identityService.saveUser(new UserEntity());
	}

	@Test
	public void testDeleteUser() {
		identityService.deleteUser("rifu");
	}

	@Test
	public void testSaveGroup() {
		identityService.saveGroup(new GroupEntity("开发组"));
	}

	@Test
	public void testDeleteGroup() {
		identityService.deleteGroup("2276");
	}

	@Test
	public void testSaveMemberShip() {
		identityService.createMembership("rifu", "开发组");
	}

	@Test
	public void testDeleteMemberShip() {
		identityService.deleteMembership("rifu", "开发组");
	}
}
