package com.example.demo2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo2.model.Guest;
@Repository
public interface HmsRepository  extends JpaRepository<Guest, Long>{

}
