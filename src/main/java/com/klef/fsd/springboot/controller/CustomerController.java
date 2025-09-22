package com.klef.fsd.springboot.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsd.springboot.model.Art;
import com.klef.fsd.springboot.model.BookArt;
import com.klef.fsd.springboot.model.Customer;
import com.klef.fsd.springboot.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*") // Allows requests from any origin
public class CustomerController 
{
   @Autowired
   private CustomerService customerService;
    
   @GetMapping("/")
   public String home()
   {
       return "FSD SDP Project";
   }
   
   @PostMapping("/registration")
   public ResponseEntity<String> customerregistration(@RequestBody Customer customer)
   {
      try
      {
         String output = customerService.customerregistration(customer);
         return ResponseEntity.ok(output);
      }
      catch(Exception e)
      {
          // Log the full stack trace for debugging
          e.printStackTrace();
          // Return a more generic, but still informative, message to the client
          return ResponseEntity.status(500).body("Customer Registration Failed.");
      }
   }
   
   @PostMapping("/checkcustomerlogin")
   public ResponseEntity<?> checkcustomerlogin(@RequestBody Customer customer) 
   {
       try 
       {
           Customer c = customerService.checkcustomerlogin(customer.getUsername(), customer.getPassword());
           if (c != null) 
           {
               return ResponseEntity.ok(c); // if login is successful
           } 
           else 
           {
               return ResponseEntity.status(401).body("Invalid Username or Password"); // if login fails
           }
       } 
       catch (Exception e) 
       {
           return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
       }
   }
   
   @PutMapping("/updateprofile")
   public ResponseEntity<String> customerupdateprofile(@RequestBody Customer customer)
   {
       try
       {
           System.out.println(customer.toString());
           String output = customerService.customerupdateprofile(customer);
           return ResponseEntity.ok(output);
       }
       catch(Exception e)
       {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body("Failed to Update Customer ... !!"); 
       }
   }

   @GetMapping("/viewallevents")
   public ResponseEntity<List<Art>> viewallevents()
   {
       List<Art> events =  customerService.viewallarts();
       return ResponseEntity.ok(events); // 200 - success
   }
   
   @PostMapping("/bookevent")
   public ResponseEntity<String> bookEvent(@RequestBody BookArt bookEvent) 
   {
       try
       {
           int bookingId = new Random().nextInt(900000) + 100000;  // 6-digit ID
           bookEvent.setId(bookingId);

           Customer customer = customerService.getCustomerById(bookEvent.getCustomer().getId());
           Art art = customerService.getArtById(bookEvent.getArt().getId());
         
           // Assign actual customer and art objects
           bookEvent.setCustomer(customer);
           bookEvent.setArt(art); // This line is corrected

           // Set status to "BOOKED"
           bookEvent.setStatus("BOOKED");

           // Pass the correctly populated object to the service
           String output = customerService.bookart(bookEvent); // This line is corrected

           return ResponseEntity.ok(output); // 200 - success
       }
       catch (Exception e) 
       {
           return ResponseEntity.status(500).body("Failed to Book an Event: " + e.getMessage());
       }
   }

   @GetMapping("/bookedevents/{cid}")
   public ResponseEntity<List<BookArt>> getEventsByCustomer(@PathVariable int cid) 
   {
       List<BookArt> bookedevents = customerService.getbookedartsByCustomer(cid);
       return ResponseEntity.ok(bookedevents); // 200 - success
   }  
}