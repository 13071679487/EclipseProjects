package com.rifu.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rifu.bean.Department;
import com.rifu.bean.Employee;
import com.rifu.dao.DepartmentMapper;
import com.rifu.dao.EmployeeMapper;

/**
 * Spring����ĿӦ��ʹ��Spring�ĵ�Ԫ���ԣ��Զ�ע��������Ҫ�����
 * 1.����SpringTestģ��
 * 2.���ע��@ContextConfigurationָ��Spring�����ļ���λ��
 * 3.ֱ��autowiredҪʹ�õ��������
 * @author Lifu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	private  DepartmentMapper departmentMapper;
	@Autowired
	private  EmployeeMapper employeeMapper;
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * ����Department
	 */
	@Test
	public void testDeptAdd(){
		//
		departmentMapper.insertSelective(new Department("������"));
		departmentMapper.insertSelective(new Department("���۲�"));
		System.out.println("��ӳɹ�");
	}
	
	@Test
	public void testDeptUpdate(){
		//
		
		System.out.println("��ӳɹ�");
	}
	
	@Test
	public void testDeptDelete(){
		//
		System.out.println("��ӳɹ�");
	}
	
	@Test
	public void testDeptSelectByPrimeyKey(){
		//
	}
	
	@Test
	public void testDeptSelectAll(){
		//
		System.out.println("��ӳɹ�");
	}
	
	@Test
	public void testDeptSelectAllByConditionals(){
		
	}
	
	@Test
	public void testEmpAdd(){
		/**
		 * ����������Ա��
		 * 
		 */
		
		for(int i=0;i<100;i++){
			String uid=UUID.randomUUID().toString().substring(0, 5)+""+i;
			employeeMapper.insertSelective(new Employee(uid,"m","528428@qq.com",2));
		}
		System.out.println("�������");
	}
	
	
}
