package nupterp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nupterp.dao.RegisterDaoI;
import nupterp.model.Tregister;
import nupterp.model.TregisterRowMapper;

@Repository
public class RegisterDaoImpl implements RegisterDaoI {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean save(Tregister t) {
		String sql = "INSERT INTO tregister(id,name,sid,sex,major,phone,qq,departments,speciality) VALUES(?,?,?,?,?,?,?,?,?)";
		if (t != null) {
			jdbcTemplate.update(sql, t.getId(), t.getName(), t.getSid(), t.getSex(), t.getMajor(),
					t.getPhone(), t.getQq(), t.getDepartments(), t.getSpeciality());
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Tregister t) {
		if (t != null) {
			String sql = "UPDATE tregister SET name=?,sid=?,sex=?,major=?,phone=?,qq=?,departments=?,speciality=? WHERE id=?";
			jdbcTemplate.update(sql, t.getName(), t.getSid(), t.getSex(), t.getMajor(), t.getPhone(),
					t.getQq(), t.getDepartments(), t.getSpeciality(),t.getId());
			return true;
		}
		return false;
	}

	@Override
	public Tregister findBySid(String sid) {
		String sql = "SELECT id,name,sid,sex,major,phone,qq,departments,speciality FROM tregister WHERE sid= ?";
		List<Tregister> list = jdbcTemplate.query(sql, new TregisterRowMapper(),sid);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Tregister findById(String id) {
		String sql = "SELECT id,name,sid,sex,major,phone,qq,departments,speciality FROM tregister WHERE id= ?";
		List<Tregister> list = jdbcTemplate.query(sql, new TregisterRowMapper(),id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM tregister WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void saveOrUpdate(Tregister t) {
		Tregister tregister = this.findById(t.getId());
		if (tregister != null) {
			this.update(t);
		} else {
			this.save(t);
		}
	}

	@Override
	public boolean checkTregisterSidExits(String sid) {
		String sql = "select count(1) from tregister where sid=?";
		if(jdbcTemplate.queryForObject(sql, Integer.class,sid)>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkTregisterIdExits(String id) {
		String sql = "select count(1) from tregister where id=?";
		if(jdbcTemplate.queryForObject(sql, Integer.class,id)>0){
			return true;
		}
		return false;
	}
	
	@Override
	public List<Tregister> find(String sql, Object... objects) {
		List<Tregister> list = jdbcTemplate.query(sql,objects, new TregisterRowMapper());
		if(list!=null){
			return list;
		}
		return null;
	}

	@Override
	public Long count(String sql, Object... objects) {
		return jdbcTemplate.queryForObject(sql,objects,Long.class);
	}

	@Override
	public Tregister findByName(String name) {
		String sql = "SELECT id,name,sid,sex,major,phone,qq,departments,speciality FROM tregister WHERE name= ?";
		List<Tregister> list = jdbcTemplate.query(sql, new TregisterRowMapper(),name);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
