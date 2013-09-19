package nupterp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TregisterRowMapper implements RowMapper<Tregister> {

	@Override
	public Tregister mapRow(ResultSet rs, int i) throws SQLException {
		Tregister t = new Tregister();
		t.setId(rs.getString("id"));
		t.setName(rs.getString("name"));
		t.setSex(rs.getString("sex"));
		t.setSid(rs.getString("sid"));
		t.setMajor(rs.getString("major"));
		t.setQq(rs.getString("qq"));
		t.setPhone(rs.getString("phone"));
		t.setDepartments(rs.getString("departments"));
		t.setSpeciality(rs.getClob("speciality"));
		return t;
	}

}
