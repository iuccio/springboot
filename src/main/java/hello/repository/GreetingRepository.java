package hello.repository;

import hello.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GreetingRepository {

    private static final Logger log = LoggerFactory.getLogger(GreetingRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer getCustomerByName(String name){
        log.info("Querying for customer records where first_name =" + name );

        List<Customer> customerList = jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
                new Object[]{name},
                (rs, rowNum) ->
                        new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));
        return customerList.get(0);
    }


}
