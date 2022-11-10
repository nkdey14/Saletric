package com.cintrix_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cintrix_1.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Integer> {

	public Billing findByMobile(String mobile);

}
