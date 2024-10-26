package com.relit.tracing;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final Repository<Customer, String> repository;
    private final Random random = new Random();

    public CustomerController(Repository<Customer, String> repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<Customer> getCustomers() throws InterruptedException {
        Thread.sleep(random.nextInt(10) * 1000);
        return repository.findAll();
    }

    @GetMapping("/{email}")
    public Customer getCustomer(@PathVariable  String email) throws InterruptedException {
        Thread.sleep(random.nextInt(10) * 1000);
        return repository.findById(email);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/{email}")
    public void deleteCustomer(@PathVariable String email) {
        repository.deleteById(email);
    }

}
