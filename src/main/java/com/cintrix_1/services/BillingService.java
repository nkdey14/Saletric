package com.cintrix_1.services;

import java.util.List;

import com.cintrix_1.entities.Billing;

public interface BillingService {

	public void saveBillDetails(Billing bill);

	public List<Billing> findAllBills();

	public Billing findBillById(int id);

	public Billing findBillByMobile(String mobile);

}
