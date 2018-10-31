package com.rifu.activiti.taskassign.group;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.junit.Test;

public class IdentityServiceDemo {
	/**
	 * ��ȡĬ�ϵ����̣�Ĭ���Ǵ�activiti.cfg.xml�ж�ȡ������Ϣ
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
		identityService.saveGroup(new GroupEntity("������"));
	}

	@Test
	public void testDeleteGroup() {
		identityService.deleteGroup("2276");
	}

	@Test
	public void testSaveMemberShip() {
		identityService.createMembership("rifu", "������");
	}

	@Test
	public void testDeleteMemberShip() {
		identityService.deleteMembership("rifu", "������");
	}
}
