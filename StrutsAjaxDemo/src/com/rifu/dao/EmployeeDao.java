package com.rifu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.rifu.entity.Employee;
import com.rifu.entity.PageInfo;

public class EmployeeDao extends BaseDao{

	public PageInfo<Employee> getEmps(int pn,int size) {
		String hql="FROM Employee";
		Query query =getSession().createQuery(hql);
		List<Employee> emps=query.list();
		PageInfo<Employee> pageInfo=new PageInfo<Employee>(size,pn,emps);
		return pageInfo;
	}

	public Employee getEmp(int id) {
		String hql="FROM Employee WHERE id = ?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		Employee emp=(Employee) query.uniqueResult();
		return emp;
	}

	public void save(Employee e) {
		System.out.println("E:"+e);
		if(e.getId()!=null){
			String hql="UPDATE Employee set name = :name,email = :email,dept = :dept where id= :id";
			Query query = getSession().createQuery(hql);
			query.setString("name", e.getName());
			query.setString("email", e.getEmail());
			query.setString("dept", e.getDept());
			query.setInteger("id", e.getId());
			query.executeUpdate();
		}else{
			getSession().saveOrUpdate(e);
		}
	}

	public void delete(Integer id) {
		String hql="DELETE FROM Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void deleteByIds(String ids){
		StringBuffer hql=new StringBuffer("DELETE FROM Employee WHERE id in(");
		hql.append(ids);
		hql.append(")");
		System.out.println("hql:"+hql);
		getSession().createQuery(hql.toString()).executeUpdate();
	}
}
