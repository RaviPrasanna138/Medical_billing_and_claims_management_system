

package com.wipro.mbcms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.InsurancePlansDTO;
import com.wipro.mbcms.entities.InsurancePlans;
import com.wipro.mbcms.services.IInsurancePlansService;

@RestController
@RequestMapping("/api/plans")
public class InsurancePlansRestController {
	Logger logger = LoggerFactory.getLogger(InsuranceCompanyRestController.class);
	@Autowired
	private IInsurancePlansService service;

	@PostMapping("/add/plan/{companyName}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsurancePlans addNewPlan(@RequestBody InsurancePlansDTO plansDto, @PathVariable String companyName) {
		return service.addInsurancePlan(plansDto, companyName);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsurancePlans updateInsurancePlans(@RequestBody InsurancePlansDTO plansDto) {
		return service.updateInsurancePlans(plansDto);
	}

	@DeleteMapping("/delete/plan/{planId}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public void deletePlans(@PathVariable int planId) {
		service.deleteInsurancePlan(planId);
		logger.info("Insurance plan with id " + planId + " is deleted!!!");
	}

	@GetMapping("/getAllPlans")
	@PreAuthorize("hasAuthority('PATIENTS')")
	public List<InsurancePlans> getAllPlans() {
		return service.getAllPlans();
	}

	@GetMapping("/getallplansbycompanyname/{companyName}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public List<InsurancePlans> getAllPlansByCompanyName(@PathVariable String companyName) {
		return service.getPlansByCompanyName(companyName);
	}

}
