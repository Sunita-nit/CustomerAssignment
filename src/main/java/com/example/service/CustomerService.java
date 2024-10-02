package com.example.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.entity.Customers;
import com.example.repository.CustomerRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	//Creating new customer
	public Customers createNewCustomer(@Valid Customers customers) {
		validateCustomer(customers);
		return customerRepository.save(customers);
	}
	
	private void validateCustomer(Customers customer){
		//Validation check for gender
		if(!customer.getSex().equals("M") && !customer.getSex().equals("F")){
			throw new IllegalArgumentException("Sex must be 'M' or 'F'");

		}
		
		//Validation for dob
		LocalDate dob = LocalDate.parse(customer.getDob(),DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		if(dob.isAfter(LocalDate.of(2002, 1, 1))) {
			throw new IllegalArgumentException("DOB must be before 01-01-2002");
		}
		
		//Validation for contractType
		if(!customer.getContractType().equals("fulltime") && !customer.getContractType().equals("parttime")) {
			throw new IllegalArgumentException("Contract Type must be fulltime or parttime");
		}
		
	}
	
	
	 // Get all customers
    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get a customer by ID
    public Customers getCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }

    // Update a customer
    public Customers updateCustomer(Long id, Customers customerDetails) {
        Customers customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setSex(customerDetails.getSex());
        customer.setDob(customerDetails.getDob());
        customer.setNativeLocation(customerDetails.getNativeLocation());
        customer.setAccountType(customerDetails.getAccountType());
        customer.setContractType(customerDetails.getContractType());
        return customerRepository.save(customer);
    }

    // Delete a customer
    public void deleteCustomer(Long id) {
        Customers customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
