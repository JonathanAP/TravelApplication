//destination row mapper for jdbc database connection
/* package fi.hh.finalproject.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DestinationRowMapper implements RowMapper<Destination> {
	@Override
	public Destination mapRow(ResultSet rs, int rowNum) throws SQLException {
		Destination destination = new Destination();
		destination.setId(rs.getInt("id"));
		destination.setDestinationName(rs.getString("name"));
		destination.setProvince(rs.getString("province"));
		destination.setMainAttraction(rs.getString("attractions"));
		destination.setRating(rs.getInt("rating"));
		return destination;
	}
}
 */