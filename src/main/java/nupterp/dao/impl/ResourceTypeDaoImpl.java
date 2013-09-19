package nupterp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nupterp.dao.ResourceTypeDaoI;
import nupterp.model.Tresourcetype;
import nupterp.model.TresourcetypeRowMapper;

@Repository
public class ResourceTypeDaoImpl implements ResourceTypeDaoI {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean save(Tresourcetype t) {
		String sql = "INSERT INTO tresourcetype(id,name) VALUES(?,?)";
		if (t != null) {
			jdbcTemplate.update(sql, t.getId(), t.getName());
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Tresourcetype t) {
		String sql = "UPDATE tresourcetype SET name=? WHERE id=?";
		if (t != null) {
			jdbcTemplate.update(sql, t.getName(), t.getId());
			return true;
		}
		return false;
	}

	@Override
	public Tresourcetype findById(String id) {
		String sql = "SELECT id,name FROM tresourcetype WHERE id= ?";
		List<Tresourcetype> list = jdbcTemplate.query(sql, new TresourcetypeRowMapper(), id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM tresourcetype WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void saveOrUpdate(Tresourcetype t) {
		Tresourcetype tresourcetype = this.findById(t.getId());
		if (tresourcetype != null) {
			update(t);
		} else {
			save(t);
		}

	}

	@Override
	public List<Tresourcetype> find(String sql, Object[] objects) {
		List<Tresourcetype> list = jdbcTemplate.query(sql,objects,new TresourcetypeRowMapper());
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public Long count(String sql, Object[] objects) {
		return jdbcTemplate.queryForObject(sql,objects,Long.class);
	}

	@Override
	public boolean checkTresourcetypeIdExits(String id) {
		String sql = "select count(1) from Tresourcetype where id=?";
		if(jdbcTemplate.queryForObject(sql, Integer.class,id)>0){
			return true;
		}
		return false;
	}

}
