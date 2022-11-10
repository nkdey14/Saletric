package com.cintrix_1.services;

import java.util.List;

import com.cintrix_1.entities.Lead;

public interface LeadService {

	public void saveLead(Lead l);

	public List<Lead> findAllLeads();

	public Lead findLeadById(int id);

	public void deleteLead(int id);

}
