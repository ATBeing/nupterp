package nupterp.dao;

import java.util.List;

public interface BaseDaoI<T> {

	public Boolean save(T o);
	
	public Boolean save(String sql,Object[] objects);
	
	public Boolean update(T o);
	
	public Boolean update(String sql,Object[] objects);
	
	public Boolean saveOrUpdate(T o);
	
	public Boolean delete(String id);
	
	public Boolean delete(String sql,Object[] objects);
	
	public T get(String sql,Object[] objects);
	
	public List<T> find(String sql,Object[] objects);
	
	public Long count(String sql,Object[] objects);
	
	
}
