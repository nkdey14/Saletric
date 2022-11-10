package com.cintrix_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cintrix_1.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	public Contact findByMobile(long mobile);

}
