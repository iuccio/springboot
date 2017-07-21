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
        log.info("Querying for customer records where firstname =" + name );

        List<Customer> customerList = jdbcTemplate.query(
                "SELECT id, firstname, lastname FROM customers WHERE firstname = ?",
                new Object[]{name},
                (rs, rowNum) ->
                        new Customer(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname")));

        if(customerList.isEmpty()){
            return null;
        }

        return customerList.get(0);
    }


}
