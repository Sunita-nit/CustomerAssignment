package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long> {

}
