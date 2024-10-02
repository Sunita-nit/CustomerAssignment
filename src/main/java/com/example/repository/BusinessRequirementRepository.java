package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BusinessRequirement;

public interface BusinessRequirementRepository extends JpaRepository<BusinessRequirement,Long>{
	
}
