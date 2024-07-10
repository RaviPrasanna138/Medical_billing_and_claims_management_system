package com.wipro.mbcms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.InsuranceClaimsDTO;
import com.wipro.mbcms.entities.InsuranceClaims;
import com.wipro.mbcms.services.IInsuranceClaimsService;

@RestController
@RequestMapping("/api/insuranceclaims")
@CrossOrigin("http://localhost:4200")
public class InsuranceClaimsRestController {

	@Autowired
	private IInsuranceClaimsService claimService;

	@GetMapping("/getallclaims")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InsuranceClaims> getAllClaims() {
		return claimService.getAllInsuranceClaims();

	}

	@PostMapping("/add/newclaim/{patientName}/{planId}")
	@PreAuthorize("hasAuthority('PATIENTS')")
	public InsuranceClaims insertNewClaim(@RequestBody InsuranceClaimsDTO claimDTO, @PathVariable String patientName,
			@PathVariable int planId) {
		System.out.println(patientName);
		return claimService.addClaims(claimDTO, patientName, planId);
	}

	@PutMapping("/update/claim/{claimId}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsuranceClaims updateStatus(@RequestBody InsuranceClaimsDTO claimDTO, @PathVariable long claimId) {
		return claimService.updateClaims(claimDTO, claimId);
	}

	@GetMapping("/getclaims/{claimId}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsuranceClaims getClaimById(@PathVariable Long claimId) {
		return claimService.getById(claimId);
	}

}
