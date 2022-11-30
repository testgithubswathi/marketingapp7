package com.marketingapp7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp7.Entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
