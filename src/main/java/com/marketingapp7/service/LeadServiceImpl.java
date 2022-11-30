package com.marketingapp7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp7.Entity.Lead;
import com.marketingapp7.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	
	
	@Override
	public void saveOneLead(Lead l) {
     leadRepo.save(l);
		}


	@Override
	public List<Lead> listAllLeads() {
		 List<Lead> lead = leadRepo.findAll();
		 return lead;
	}


	@Override
	public void deleteOneLead(long id) {
		leadRepo.deleteById(id);
	}


	@Override
	public Lead updateLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
		
	}


	

}
