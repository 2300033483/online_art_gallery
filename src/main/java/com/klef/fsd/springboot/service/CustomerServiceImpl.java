package com.klef.fsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.springboot.model.Art;
import com.klef.fsd.springboot.model.BookArt;
import com.klef.fsd.springboot.model.Customer;
import com.klef.fsd.springboot.repository.ArtRepository;
import com.klef.fsd.springboot.repository.BookArtRepository;
import com.klef.fsd.springboot.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
    private CustomerRepository customerRepository;
	
	@Autowired
	private ArtRepository artRepository;
	
	@Autowired
	private BookArtRepository bookartRepository;
	
	@Override
	public String customerregistration(Customer customer) 
	{
		customerRepository.save(customer);
		return "Customer Registered Successfully";
	}

	@Override
	public Customer checkcustomerlogin(String username, String password) 
	{
		return customerRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public String customerupdateprofile(Customer customer) 
	{
		Optional<Customer> object	= customerRepository.findById(customer.getId());
		
		String msg = null;
			  
			  if(object.isPresent())
			  {
				  Customer c = object.get();
				  
				  c.setName(customer.getName());
				  c.setDob(customer.getDob());
				  c.setMobileno(customer.getMobileno());
				  c.setEmail(customer.getEmail());
				  c.setPassword(customer.getPassword());
				  c.setLocation(customer.getLocation());
				  
				  customerRepository.save(customer);
				  
				  msg = "Customer Profile Updated Successfully";
			  }
			  else
			  {
				  msg = "Customer ID Not Found to Update";
			  }
			  return msg;
	}

	@Override
	public List<Art> viewallarts() 
	{
	   return artRepository.findAll();
	}

	@Override
	public Customer getCustomerById(int cid) 
	{
		return customerRepository.findById(cid).orElse(null);
	}

	@Override
	public Art getArtById(int eid) 
	{
		return artRepository.findById(eid).orElse(null);
	}

	@Override
	public String bookart1(BookArt bookart) 
	{
		bookartRepository.save(bookart);
		return "Event Booked Successfully";
	}

	@Override
	public List<BookArt> getbookedartsByCustomer(int cid) 
	{
		Customer customer = customerRepository.findById(cid).orElse(null);
		return bookartRepository.findByCustomer(customer);
	}

	@Override
	public String bookart(BookArt bookart) {
		// TODO Auto-generated method stub
		return null;
	}

}
