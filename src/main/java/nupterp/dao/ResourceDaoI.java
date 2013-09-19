package nupterp.dao;

import java.util.List;

import nupterp.model.Tresource;

public interface ResourceDaoI {
public boolean save(Tresource t);
	
	public boolean update(Tresource t);
	
	public Tresource findById(String id);
	
	public void delete(String id);
	
	public void saveOrUpdate(Tresource t);
	
	public List<Tresource> find(String sql, Object... objects);
	
	public Long count(String sql, Object... objects);
	
	public boolean checkTresourceIdExits(String id);
	
}
