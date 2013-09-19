package nupterp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TuserRowMapper implements RowMapper<Tuser> {

	@Override
	public Tuser mapRow(ResultSet rs, int index) throws SQLException {
		Tuser t = new Tuser();
		t.setName(rs.getString("name"));
		t.setId(rs.getString("id"));
		t.setSid(rs.getString("sid"));
		t.setCreatetime(rs.getDate("createtime"));
		t.setModifytime(rs.getDate("modifytime"));
		t.setRole(rs.getString("role"));
		return t;
	}

}
