package com.marketingapp7.service;

import java.util.List;

import com.marketingapp7.Entity.Lead;

public interface LeadService {
public void saveOneLead(Lead l);

public List<Lead> listAllLeads();

public void deleteOneLead(long id);

public Lead updateLead(long id);
}
