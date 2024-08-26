package com.lodgemanagment.app.service;

import com.lodgemanagment.app.entity.Customer;
import com.lodgemanagment.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }
    public boolean validateCustomer(String email, String password)
    {
       Optional<Customer> customer= customerRepository.findByEmail(email);
       return customer.isPresent() && customer.get().getPassword().equals(password);
    }


}
