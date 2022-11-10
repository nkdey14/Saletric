package com.cintrix_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cintrix_1.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Integer> {

}
