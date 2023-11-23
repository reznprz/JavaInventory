package com.laxmi.inventory.management.inventory.mySqlRepository;

import com.laxmi.inventory.management.inventory.Model.Customer;
import com.laxmi.inventory.management.inventory.Model.DBRow;
import com.laxmi.inventory.management.inventory.Model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

@Repository
@PropertySources(
        {
                @PropertySource(value = "classpath:sql-cus.properties"),
                @PropertySource(value = "classpath:sql-user.properties"),
                @PropertySource(value = "classpath:sql-invoice.properties"),
                @PropertySource(value = "classpath:sql-invoiceProduct.properties")
        }
)
public class SQLRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${select.all.user}")
    private String getUserSelectSql;

    @Value("${select.all.customer}")
    private String getCusSelectSql;

    @Value("${create.invoice}")
    private String createInvoiceSql;

    @Value("${create.invoiceProduct}")
    private String createInvoiceProductSql;

    @Value("${count.customer.exits}")
    private String customerExistsSql;

    @Value("${create.customer}")
    private String createCustomerSql;

    @Value("${customerID.by.email}")
    private String customerIdByEmailSql;

    @Value("${count.invoice.exits}")
    private String invoiceExistsSql;

    @Value("${count.invoiceProducts.exits}")
    private String invoiceProductsExistsSql;


    public SQLRepository(@Qualifier("jdbcSecondaryTemplate") NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DBRow> getAllUsers() {
        final String[] propertyNames = {"username", "password"};
        String sql = "Select * from users";
        return getQueryResults(getUserSelectSql, propertyNames);
    }

    public List<Customer> getAllCustomers() {
        String sql = "Select * from Customer";
        return jdbcTemplate.query(getCusSelectSql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer getCustomerById(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        String sql = "Select * from Customer where customerId = :cusId";
        params.addValue("cusId", id);
        return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Integer getCustomerByEmail(String email) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);
        return jdbcTemplate.queryForObject(
                customerIdByEmailSql,
                params,
                Integer.class
        );
    }

    public boolean invoiceExists(int invoiceId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", invoiceId);

        int count = jdbcTemplate.queryForObject(invoiceExistsSql, params, Integer.class);
        return count > 0;
    }

    @Transactional
    public void createInvoice(Invoice invoice) {

        MapSqlParameterSource invoiceParams = new MapSqlParameterSource();
        invoiceParams.addValue("id", invoice.getId());
        invoiceParams.addValue("customerId", invoice.getCustomerId());
        invoiceParams.addValue("amountBeforeDiscount", invoice.getAmountBeforeDiscount());
        invoiceParams.addValue("discount", invoice.getDiscount());
        invoiceParams.addValue("totalAmount", invoice.getTotalAmount());

        jdbcTemplate.update(createInvoiceSql, invoiceParams);

    }

    public boolean invoiceProductsExists(int invoiceId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("invoiceId", invoiceId);

        int count = jdbcTemplate.queryForObject(invoiceProductsExistsSql, params, Integer.class);
        return count > 0;
    }

    @Transactional
    public void createInvoiceProduct(int invoiceId, List<Integer> productIds) {

        for (Integer productId : productIds) {
            MapSqlParameterSource productParams = new MapSqlParameterSource();
            productParams.addValue("invoiceId", invoiceId);
            productParams.addValue("productId", productId);

            jdbcTemplate.update(createInvoiceProductSql, productParams);
        }

    }

    @Transactional
    public void createCustomer(Customer customer) {

        MapSqlParameterSource cusParams = new MapSqlParameterSource();
        cusParams.addValue("phoneNumber", customer.getPhoneNumber());
        cusParams.addValue("firstName", customer.getFirstName());
        cusParams.addValue("lastName", customer.getLastName());
        cusParams.addValue("address1", customer.getAddress1());
        cusParams.addValue("address2", customer.getAddress2());
        cusParams.addValue("address3", customer.getAddress3());
        cusParams.addValue("zipCode", customer.getZipCode());
        cusParams.addValue("city", customer.getCity());
        cusParams.addValue("email", customer.getEmail());

        jdbcTemplate.update(createCustomerSql, cusParams);

    }

    public boolean customerExists(String email, String firstName) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);
        params.addValue("firstName", firstName);

        int count = jdbcTemplate.queryForObject(customerExistsSql, params, Integer.class);
        return count > 0;
    }

    private List<DBRow> getQueryResults(String sql, String[] propertiesNames) {
        List<DBRow> queryResults = jdbcTemplate.query(sql, (RowMapper) (resultSet, rowNum) -> resultRowMapper(resultSet, propertiesNames));
        return queryResults;
    }

    private List<DBRow> getQueryResultsWithParams(String sql, String[] propertyName, SqlParameterSource parameters) {
        List<DBRow> queryResultRows = jdbcTemplate.query(sql, parameters, (resultSet, rowNum) -> resultRowMapper(resultSet, propertyName));
        return queryResultRows;
    }

    protected DBRow resultRowMapper(ResultSet rs, String[] propertyNames) throws SQLException {
        HashMap<String, Object> resultMap = new HashMap<>();
        for (String property : propertyNames) {
            try {
                Object fieldValue = rs.getObject(property);
                if (fieldValue instanceof Timestamp)
                    fieldValue = timestampEasternString((Timestamp) fieldValue);
                resultMap.put(property, fieldValue);
            } catch (SQLException e) {
                throw e;
            }
        }
        return new DBRow(resultMap);
    }

    protected String timestampEasternString(Timestamp ts) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return sdf.format(ts);
    }
}
