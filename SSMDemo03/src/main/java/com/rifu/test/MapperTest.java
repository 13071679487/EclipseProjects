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
 * Spring的项目应该使用Spring的单元测试，自动注入我们需要的组件
 * 1.导入SpringTest模块
 * 2.添加注解@ContextConfiguration指定Spring配置文件的位置
 * 3.直接autowired要使用的组件即可
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
	 * 测试Department
	 */
	@Test
	public void testDeptAdd(){
		//
		departmentMapper.insertSelective(new Department("开发部"));
		departmentMapper.insertSelective(new Department("销售部"));
		System.out.println("添加成功");
	}
	
	@Test
	public void testDeptUpdate(){
		//
		
		System.out.println("添加成功");
	}
	
	@Test
	public void testDeptDelete(){
		//
		System.out.println("添加成功");
	}
	
	@Test
	public void testDeptSelectByPrimeyKey(){
		//
	}
	
	@Test
	public void testDeptSelectAll(){
		//
		System.out.println("添加成功");
	}
	
	@Test
	public void testDeptSelectAllByConditionals(){
		
	}
	
	@Test
	public void testEmpAdd(){
		/**
		 * 批量插入多个员工
		 * 
		 */
		
		for(int i=0;i<100;i++){
			String uid=UUID.randomUUID().toString().substring(0, 5)+""+i;
			employeeMapper.insertSelective(new Employee(uid,"m","528428@qq.com",2));
		}
		System.out.println("批量完成");
	}
	
	
}
