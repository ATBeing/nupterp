package nupterp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TresourceRowMapper implements RowMapper<Tresource> {

	@Override
	public Tresource mapRow(ResultSet rs, int i) throws SQLException {
		Tresource t = new Tresource();
		t.setId(rs.getString("id"));
		t.setName(rs.getString("name"));
		t.setIcon(rs.getString("icon"));
		t.setSeq(rs.getInt("seq"));
		t.setUrl(rs.getString("url"));
		t.setRemark(rs.getString("remark"));
		t.setPid(rs.getString("pid"));
		t.setTresourcetypeid(rs.getString("tresourcetypeid"));
		return t;
		
	}

}
