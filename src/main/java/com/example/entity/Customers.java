package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String sex;
	private String dob;  //Change later to LocalDate
	private String nativeLocation;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getNativeLocation() {
		return nativeLocation;
	}

	public void setNativeLocation(String nativeLocation) {
		this.nativeLocation = nativeLocation;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<BusinessRequirement> getBusinessRequirement() {
		return businessRequirement;
	}

	public void setBusinessRequirement(List<BusinessRequirement> businessRequirement) {
		this.businessRequirement = businessRequirement;
	}

	
	@Column(name ="account_type")
	private String accountType;
	
	@Column(name ="contract_type")
	private String contractType;
	
	@OneToMany(mappedBy ="customer", cascade = CascadeType.ALL)
	private List<BusinessRequirement> businessRequirement = new ArrayList<>();
	
    public void addBusinessRequirement(BusinessRequirement requirement) {
    	requirement.setCustomer(this); 
        this.businessRequirement.add(requirement);
    }
	
	
	
	
	
}
