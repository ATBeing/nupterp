package nupterp.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nupterp.dao.UserDaoI;
import nupterp.model.Tuser;
import nupterp.model.TuserRowMapper;
import nupterp.util.MD5Util;

@Repository
public class UserDaoImpl implements UserDaoI {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean save(Tuser t) {
		String sql = "INSERT INTO tuser(id,name,pwd,sid,createtime,role) VALUES(?,?,?,?,?,?)";
		if (t != null) {
			jdbcTemplate.update(sql, t.getId(), t.getName(), MD5Util.md5(t.getPwd()), t.getSid(), new Date(),t.getRole());
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Tuser t) {
		if (t != null) {
			String sql = "UPDATE tuser SET name=?,sid=?,role=?,modifytime=? WHERE id=?";
			jdbcTemplate.update(sql, t.getName(),t.getSid(),t.getRole(),t.getModifytime(),t.getId());
			return true;
		}
		return false;

	}

	@Override
	public Tuser findBySid(String sid) {
		String sql = "SELECT * FROM tuser WHERE sid= ?";
		List<Tuser> list = jdbcTemplate.query(sql, new TuserRowMapper(),sid);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Tuser findById(String id) {
		String sql = "SELECT * FROM tuser t WHERE t.id=?";
		List<Tuser> list = jdbcTemplate.query(sql, new TuserRowMapper(),id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM tuser WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void saveOrUpdate(Tuser t) {
		Tuser tuser = this.findById(t.getId());
		if (tuser != null) {
			this.update(t);
		} else {
			this.save(t);
		}
	}

	@Override
	public List<Tuser> findAll() {
		String sql = "SELECT * FROM tuser";
		return jdbcTemplate.query(sql, new TuserRowMapper());
	}

	@Override
	public boolean checkTuserSidExits(String sid) {
		String sql = "select count(1) from tuser where sid=?";
		if(jdbcTemplate.queryForObject(sql, Integer.class,sid)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Tuser> find(String sql, Object... objects) {
		List<Tuser> list = jdbcTemplate.query(sql,objects, new TuserRowMapper());
		if(list!=null){
			return list;
		}
		return null;
	}

	@Override
	public Long countAll() {
		String sql = "select count(1) from tuser";
		return (long)jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public Long count(String sql, Object... objects) {
		return jdbcTemplate.queryForObject(sql,objects,Long.class);
	}

	@Override
	public boolean checkTuserIdExits(String id) {
		String sql = "select count(1) from tuser where id=?";
		if(jdbcTemplate.queryForObject(sql, Integer.class,id)>0){
			return true;
		}
		return false;
	}

	@Override
	public Tuser findByName(String name) {
		String sql = "SELECT * FROM tuser WHERE name= ?";
		List<Tuser> list = jdbcTemplate.query(sql, new TuserRowMapper(),name);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Tuser get(String sql, Object... objects) {
		List<Tuser> list = jdbcTemplate.query(sql,objects, new TuserRowMapper());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
