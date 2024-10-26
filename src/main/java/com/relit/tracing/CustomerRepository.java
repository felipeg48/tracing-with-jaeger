package com.relit.tracing;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CustomerRepository implements Repository<Customer, String> {
    private HashMap<String, Customer> customers = new HashMap<>();

    public CustomerRepository() {
        customers.put("john@email.com", new Customer("john@email.com", "John Doe", "123-456-7890"));
        customers.put("jane@email.com", new Customer("jane@email.com", "Jane Doe", "123-456-7890"));
    }


    @Override
    public Customer save(Customer entity) {
        return customers.put(entity.email(), entity);
    }

    @Override
    public Customer findById(String id) {
        return customers.get(id);
    }

    @Override
    public void deleteById(String id) {
        customers.remove(id);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customers.values();
    }
}
