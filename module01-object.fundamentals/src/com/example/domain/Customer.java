package com.example.domain;

import java.util.List;

public class Customer {
	private String identity;
	private String fullname;
	private List<Address> addresses;
	public Customer(String identity, String fullname, List<Address> addresses) {
		this.identity = identity;
		this.fullname = fullname;
		this.addresses = addresses;
	}
	public String getIdentity() {
		return identity;
	}
	public String getFullname() {
		return fullname;
	}
	public List<Address> getAddresses() {
		return List.copyOf(addresses);
	}
	
	
}
