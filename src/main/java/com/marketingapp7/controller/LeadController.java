package com.marketingapp7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp7.Entity.Lead;
import com.marketingapp7.service.LeadService;
import com.marketingapp7.util.EmailService;
import com.marketingapp7.util.EmailServiceImpl;
@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/viewLeadPage")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("Lead")Lead l,ModelMap model) {
		leadService.saveOneLead(l);
		EmailServiceImpl email=new EmailServiceImpl();
		emailService.sendSimpleMail(l.getEmail(),"Test", "Test Email");
		model.addAttribute("msg", "lead is saved");
		return "create_lead";
		}
	      @RequestMapping("/listAllLeads")
          public String listAll(ModelMap model) {
	    	  List<Lead> lead = leadService.listAllLeads();  
	    	model.addAttribute("lead", lead);
			return "list_all";
        	  }
	      @RequestMapping("/deleteLead")
	      public String deleteLead(@RequestParam("id")long id,ModelMap model) {
	    	  leadService.deleteOneLead(id);
	    	  List<Lead> lead = leadService.listAllLeads();  
		    	model.addAttribute("lead", lead);
				return "list_all";
	      }
	      
	      @RequestMapping("/updateLead")
	      public String updateLead(@RequestParam("id")long id,Model model) {
	    	  Lead lead = leadService.updateLead(id);
	    	    model.addAttribute("lead", lead);
			return "update_lead";
}
	      
	      @RequestMapping("/updateoneLead")
	  	public String updateoneLead(@ModelAttribute("Lead")Lead l,ModelMap model) {
	  		leadService.saveOneLead(l);
	  		List<Lead> lead = leadService.listAllLeads();  
	    	model.addAttribute("lead", lead);
			return "list_all";
	  		}

}
