package com.owmax.service;

import java.util.List;


public interface BaseService<T> {
	public void save(T t);
	
	public void update(T t);
	
	public void merge(T t);
	
	public void delete(int id);
	
	public T get(int id);
	
	public List<T> queryALL();

}
