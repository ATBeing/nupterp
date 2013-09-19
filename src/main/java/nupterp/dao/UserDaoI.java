package nupterp.dao;

import java.util.List;

import nupterp.model.Tuser;

public interface UserDaoI {

	public boolean save(Tuser t);

	public boolean update(Tuser t);

	public Tuser findBySid(String sid);

	public Tuser findById(String id);

	public void delete(String id);

	public void saveOrUpdate(Tuser t);

	public List<Tuser> findAll();

	public boolean checkTuserSidExits(String sid);

	public List<Tuser> find(String sql, Object... objects);

	public Long count(String sql, Object... objects);

	public Long countAll();
	
	public boolean checkTuserIdExits(String id);
	
	public Tuser findByName(String name);
	
	public Tuser get(String sql,Object... objects);

}
