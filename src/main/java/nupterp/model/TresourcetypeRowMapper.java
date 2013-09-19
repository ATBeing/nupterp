package nupterp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TresourcetypeRowMapper implements RowMapper<Tresourcetype> {

	@Override
	public Tresourcetype mapRow(ResultSet rs, int i) throws SQLException {
		Tresourcetype t = new Tresourcetype();
		t.setId(rs.getString("id"));
		t.setName(rs.getString("name"));
		return t;
	}

}
