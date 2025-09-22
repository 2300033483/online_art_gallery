package com.klef.fsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.springboot.model.Admin;
import com.klef.fsd.springboot.model.Customer;
import com.klef.fsd.springboot.repository.AdminRepository;
import com.klef.fsd.springboot.repository.ArtRepository;
import com.klef.fsd.springboot.repository.CustomerRepository;
@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
    private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ArtRepository artRepository;
	
	@Override
	public Admin checkadminlogin(String username, String password) 
	{
		return adminRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public String addart(Admin admin)
	{
		adminRepository.save(admin);
		return "Event Manager Added Successfully";
	}

	

	@Override
	public List<Customer> displaycustomers() 
	{
		return customerRepository.findAll();
	}

	@Override
	public String deletecustomer(int cid) 
	{
	    Optional<Customer> customer = customerRepository.findById(cid);
	    
	    if (customer.isPresent()) 
	    {	
	        customerRepository.deleteById(cid);
	        return "Customer Deleted Successfully";
	    } 
	    else 
	    {
	        return "Customer ID Not Found";
	    }
	}

	
}