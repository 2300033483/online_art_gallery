package com.klef.fsd.springboot.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.klef.fsd.springboot.model.BookArt;
import com.klef.fsd.springboot.model.Customer;



@Repository
public interface BookArtRepository extends JpaRepository<BookArt, Integer>
{
    public List<BookArt> findByCustomer(Customer customer);

}

