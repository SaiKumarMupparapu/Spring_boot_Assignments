package com.Examole.demo.Entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GenericGenerator(name = "cust_Id", strategy = "com.Examole.demo.CustomGenerator.CustimizedIdGenerator")
	@GeneratedValue(generator = "cust_Id")
	private String cid;

	private String name;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + "]";
	}

}
