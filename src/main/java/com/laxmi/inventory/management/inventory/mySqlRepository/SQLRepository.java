package com.laxmi.inventory.management.inventory.mySqlRepository;

import com.laxmi.inventory.management.inventory.Model.DBRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

@Repository
//@PropertySource(value = "classpath:sql.properties")
public class SQLRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;


    public SQLRepository(@Qualifier("jdbcSecondaryTemplate") NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DBRow> getAllUsers(){
        final String[] propertyNames = {"username", "password"};
        String sql = "Select * from users";
        return getQueryResults(sql, propertyNames);
    }

    private List<DBRow> getQueryResults(String sql, String[] propertiesNames){
        List<DBRow> queryResults = jdbcTemplate.query(sql, (RowMapper) (resultSet, rowNum) -> resultRowMapper(resultSet, propertiesNames));
        return queryResults;
    }

    private List<DBRow> getQueryResultsWithParams(String sql, String[] propertyName, SqlParameterSource parameters){
        List<DBRow> queryResultRows = jdbcTemplate.query(sql, parameters, (resultSet, rowNum) -> resultRowMapper(resultSet, propertyName));
        return queryResultRows;
    }

    protected DBRow resultRowMapper(ResultSet rs, String[] propertyNames) throws SQLException {
        HashMap<String, Object> resultMap = new HashMap<>();
        for(String property : propertyNames){
            try{
                Object fieldValue = rs.getObject(property);
                if(fieldValue instanceof Timestamp)
                    fieldValue = timestampEasternString((Timestamp) fieldValue);
                resultMap.put(property, fieldValue);
            }catch (SQLException e){
                throw  e;
            }
        }
        return new DBRow(resultMap);
    }

    protected String timestampEasternString(Timestamp ts){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return  sdf.format(ts);
    }
}
