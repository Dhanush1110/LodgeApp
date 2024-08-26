package com.lodgemanagment.app.controller;

import com.lodgemanagment.app.entity.Customer;
import com.lodgemanagment.app.repository.CustomerRepository;
import com.lodgemanagment.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer)
    {
        return  customerService.saveCustomer(customer);
    }
    @GetMapping("/login")
    public boolean loginValidation(@RequestParam String email, @RequestParam String password)
    {
        boolean isValidCustomer=customerService.validateCustomer(email, password);
        return customerService.validateCustomer(email, password);
    }
}
