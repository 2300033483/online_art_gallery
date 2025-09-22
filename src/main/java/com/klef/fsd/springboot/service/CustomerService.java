package com.klef.fsd.springboot.service;

import java.util.List;

import com.klef.fsd.springboot.model.Art;
import com.klef.fsd.springboot.model.BookArt;
import com.klef.fsd.springboot.model.Customer;



public interface CustomerService 
{
  public String customerregistration(Customer customer);
  public Customer checkcustomerlogin(String username,String password);
  
  public String customerupdateprofile(Customer customer);
  
  public List<Art> viewallarts();
  
  public Customer getCustomerById(int cid);
  public Art getArtById(int eid);
  
  public String bookart1(BookArt bookart);
  public List<BookArt> getbookedartsByCustomer(int cid);
String bookart(BookArt bookart);
  
}