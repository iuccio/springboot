package hello.controller;

import java.util.concurrent.atomic.AtomicLong;

import hello.repository.GreetingRepository;
import hello.entity.Customer;
import hello.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @RequestMapping(method = RequestMethod.GET,value = "/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/name")
    public Customer getCustomerByName(@RequestParam(value = "name") String name){
        Customer customerByName = greetingRepository.getCustomerByName(name);
        return customerByName;
    }

    @RequestMapping("/customer")
    public Response getCustomerResponse(@RequestParam(value = "name") String name){
        Customer customerByName = greetingRepository.getCustomerByName(name);
        return Response.ok(customerByName).build();
    }
}