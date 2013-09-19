package nupterp.dao;

import java.util.List;

import nupterp.model.Tresourcetype;

public interface ResourceTypeDaoI {
public boolean save(Tresourcetype tregister);
	
	public boolean update(Tresourcetype tregister);
	
	public Tresourcetype findById(String id);
	
	public void delete(String id);
	
	public void saveOrUpdate(Tresourcetype t);
	
	public List<Tresourcetype> find(String sql, Object[] objects);
	
	public Long count(String sql, Object[] objects);
	
	public boolean checkTresourcetypeIdExits(String id);
}
