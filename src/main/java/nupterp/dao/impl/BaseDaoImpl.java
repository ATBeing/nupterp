package nupterp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import nupterp.dao.BaseDaoI;

public class BaseDaoImpl<T> implements BaseDaoI<T> {

	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Boolean save(T o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(String sql, Object[] objects) {
		int i = jdbcTemplate.update(sql,objects);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(T o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(String sql, Object[] objects) {
		int i = jdbcTemplate.update(sql,objects);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public Boolean saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String sql, Object[] objects) {
		int i = jdbcTemplate.update(sql,objects);
		if(i>0){
			return true;
		}
		return false;
	}
	
	@Override
	public T get(String sql, Object[] objects) {
//		List<T> list = jdbcTemplate.query(sql, objects);
		return null;
	}

	@Override
	public List<T> find(String sql, Object[] objects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count(String sql, Object[] objects) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
