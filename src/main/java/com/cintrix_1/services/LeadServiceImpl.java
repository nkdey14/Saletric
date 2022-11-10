package com.cintrix_1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cintrix_1.entities.Lead;
import com.cintrix_1.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLead(Lead l) {
		
		leadRepo.save(l);
	}

	@Override
	public List<Lead> findAllLeads() {
		
		List<Lead> leads = leadRepo.findAll();
		
		return leads;
	}

	@Override
	public Lead findLeadById(int id) {
		
		Optional<Lead> findById = leadRepo.findById(id);
		
		Lead lead = findById.get();
		
		return lead;
	}

	@Override
	public void deleteLead(int id) {
		
		leadRepo.deleteById(id);
		
	}
}
