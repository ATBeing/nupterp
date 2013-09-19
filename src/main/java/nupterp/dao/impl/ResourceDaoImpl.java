package nupterp.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nupterp.dao.ResourceDaoI;
import nupterp.model.Tresource;
import nupterp.model.TresourceRowMapper;

@Repository
public class ResourceDaoImpl implements ResourceDaoI {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean save(Tresource t) {
		String sql = "INSERT INTO tresource(id,name,icon,remark,seq,url,pid,tresourcetypeid) VALUES(?,?,?,?,?,?,?,?)";
		if (t != null) {
			jdbcTemplate.update(sql, t.getId(), t.getName(), t.getIcon(), t.getRemark(), t.getSeq(),
					t.getUrl(), t.getPid(), t.getTresourcetypeid());
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Tresource t) {
		if (t != null) {
			String sql = "UPDATE tresource SET name=?,icon=?,remark=?,seq=?,url=?,pid=?,tresourcetypeid=? WHERE id=?";
			jdbcTemplate.update(sql, t.getName(), t.getIcon(), t.getRemark(), t.getSeq(), t.getUrl(),
					 t.getPid(), t.getTresourcetypeid(),t.getId());
			return true;
		}
		return false;
	}

	@Override
	public Tresource findById(String id) {
		String sql = "SELECT id,name,icon,remark,seq,url,pid,tresourcetypeid FROM tresource WHERE id= ?";
		List<Tresource> list = jdbcTemplate.query(sql, new TresourceRowMapper(),id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM tresource WHERE id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void saveOrUpdate(Tresource t) {
		Tresource tresource = this.findById(t.getId());
		if (tresource != null) {
			this.update(t);
		} else {
			this.save(t);
		}
	}

	@Override
	public List<Tresource> find(String sql, Object... objects) {
		List<Tresource> list = jdbcTemplate.query(sql,objects, new TresourceRowMapper());
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
	public boolean checkTresourceIdExits(String id) {
		String sql = "select count(1) from tresource where id=?";
		if(jdbcTemplate.queryForObject(sql, Integer.class,id)>0){
			return true;
		}
		return false;
	}

}
