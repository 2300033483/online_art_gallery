package com.klef.fsd.springboot.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsd.springboot.model.Admin;
import com.klef.fsd.springboot.model.Art;



@Repository
public interface ArtRepository extends JpaRepository<Art, Integer>
{
    public List<Art> findByAdmin(Admin admin);
    
    
}
