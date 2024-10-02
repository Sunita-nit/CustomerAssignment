package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "business_requirement")
public class BusinessRequirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requirementId;
	
	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customers customer;
	
	private String requirements;
	
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public void setRequirements(BusinessRequirement requirementString) {
		this.requirements = requirements;
	}
	
	
	
}
