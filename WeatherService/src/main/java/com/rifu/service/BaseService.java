package com.rifu.service;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 
 * @author Lifu
 *
 * @param <M>		bean����
 * @param <E>		bean��example����
 */
@Service
public interface BaseService<M,E>{
	public M getObjectByPrimarykey(Object id);
	
	public int insertObject(M m);
	
	public int updateObject(M m);
	
	public int deleteObjectByPrimarykey(Object id);
	
	public List<M> getObjectsByExample(E e);
}
