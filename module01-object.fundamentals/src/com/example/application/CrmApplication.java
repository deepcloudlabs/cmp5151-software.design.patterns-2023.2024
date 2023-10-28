package com.example.application;

import java.util.ArrayList;

import com.example.domain.Address;
import com.example.domain.Customer;

public class CrmApplication {

	public static void main(String[] args) {
		var addresses = new ArrayList<Address>();
		Customer customer= new Customer("1", "kate austen", addresses);
		// violate information hiding
		//customer.getAddresses().add(new Address());
		//customer.getAddresses().clear();
		customer.getFullname().toUpperCase();
		System.out.println(customer.getFullname());
		
	}

}
