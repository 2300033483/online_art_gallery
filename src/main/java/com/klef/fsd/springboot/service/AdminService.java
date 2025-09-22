package com.klef.fsd.springboot.service;

import java.util.List;

import com.klef.fsd.springboot.model.Admin;
import com.klef.fsd.springboot.model.Customer;

public interface AdminService {

	public Admin checkadminlogin(String username, String password);

	 public String addart(Admin admin);

	public List<Customer> displaycustomers();

	public String deletecustomer(int cid);

}
