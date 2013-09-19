package nupterp.dao;

import java.util.List;

import nupterp.model.Tregister;

public interface RegisterDaoI {
	public boolean save(Tregister tregister);
	
	public boolean update(Tregister tregister);
	
	public Tregister findBySid(String sid);
	
	public Tregister findById(String id);
	
	public void delete(String id);
	
	public void saveOrUpdate(Tregister t);
	
	public boolean checkTregisterSidExits(String sid);
	
	public List<Tregister> find(String sql, Object... objects);
	
	public Long count(String sql, Object... objects);
	
	public boolean checkTregisterIdExits(String id);
	
	public Tregister findByName(String name);
	
}
