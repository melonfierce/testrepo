package dao;

import model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Austin on 2/19/2015.
 */

@Repository
public class DerbyDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Record> getAllRecords() {
        List<Record> records;

        String query = "select * from APP.EMPLOYEES";
        try {
            records = jdbcTemplate.query(query, new RecordMapper());
            return records;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Record> getRecordsWithIn(List<String> jobTitles) {
        List<Record> records;

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("jobTitles",jobTitles);

        String query = "select * from APP.EMPLOYEES where job_title in (:jobTitles)";

        records = jdbcTemplate.query(query, new RecordMapper(), parameters);

        return records;
    }





    private class RecordMapper implements RowMapper<Record> {

        public Record mapRow(ResultSet rs, int numRows) throws SQLException {
            Record record = new Record();
            record.setId(rs.getString("id"));
            record.setFirstName(rs.getString("first_name"));
            record.setLastName(rs.getString("last_name"));
            record.setJobTitle(rs.getString("job_title"));
            return record;
        }
    }
}
