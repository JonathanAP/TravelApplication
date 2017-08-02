//repository for fetching information from database
/*
package fi.hh.finalproject.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TravelRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Destination> findAll() {
		return jdbcTemplate.query("select * from destination", new DestinationRowMapper());
	}
}
*/