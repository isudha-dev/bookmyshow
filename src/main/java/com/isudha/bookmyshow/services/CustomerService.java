package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.dtos.CreateCustomerDto;
import com.isudha.bookmyshow.models.Customer;
import com.isudha.bookmyshow.models.User;
import com.isudha.bookmyshow.repositories.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {
    private CustomerRepo customerRepo;
    private UserService userService;

    public Customer getCustomerById(Long id){
        return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Optional<Customer> getCustomerByEmail(String email){
        return customerRepo.findByEmail(email);
    }

    public Customer createCustomer(CreateCustomerDto reqDto){
        // check if customer already exists
        Optional<Customer> customer = customerRepo.findByEmail(reqDto.getEmail());
        if(customer.isPresent()){
            throw new RuntimeException("Customer already exists");
        }

        User user = userService.createUser(reqDto.getUsername(), reqDto.getPassword());

        Customer newCustomer = Customer
                .builder()
                .user(user)
                .email(reqDto.getEmail())
                .fullName(reqDto.getFullname())
                .phone(reqDto.getPhone())
                .build();

        return customerRepo.save(newCustomer);
    }

}
