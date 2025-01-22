package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
	
}
