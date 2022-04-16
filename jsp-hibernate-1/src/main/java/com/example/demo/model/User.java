package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//employee
	private Integer id;
	
	@Column(name="name", nullable=false)
	String name;
	@Column(name="salary", nullable=false)
	Double salary;
	@Column(name="department", nullable=false)
	String department;
	@Column(name="address", nullable=false)
	String address;
	@Column(name="phone", nullable=false)
	String phoneNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}
