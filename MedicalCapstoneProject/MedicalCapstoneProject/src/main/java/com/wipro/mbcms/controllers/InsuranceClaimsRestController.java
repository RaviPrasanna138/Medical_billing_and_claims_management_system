package com.wipro.mbcms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/InsuranceClaims")
public class InsuranceClaimsRestController {
	
	@Autowired
	private IInsuranceClaimsService claimService;
	
	//add , update ,  get all , get by id 
	
	@GetMapping("/getallclaims")
	public List<InsuranceClaims> getAllClaims() {
		return claimService.getAllInsuranceClaims();

	}
	
	@PostMapping("/add/newclaim/{patientName}/{planId}")
	public InsuranceClaims insertNewClaim(@RequestBody InsuranceClaimsDTO claimDTO,@PathVariable String patientName,@PathVariable int planId) {
		System.out.println(patientName);
		return claimService.addClaims(claimDTO, patientName, planId);
	}
	

	@PutMapping("/update/claim/{claimId}")
	public InsuranceClaims updateStatus(@RequestBody InsuranceClaimsDTO claimDTO, @PathVariable long claimId) {
		return claimService.updateClaims(claimDTO, claimId);
	}
	
	@GetMapping("/getclaims/{patientName}")
	public List<InsuranceClaims> getClaimByCompanyName(@PathVariable String patientName)
	{
		return claimService.getClaimByPatientName(patientName);
	}
	
    @GetMapping("/getClaims/{patinetId}")
    public InsuranceClaims getClaimbyId(@PathVariable Long patientId){
    	return claimService.getByPatientId(patientId);
    }

}
