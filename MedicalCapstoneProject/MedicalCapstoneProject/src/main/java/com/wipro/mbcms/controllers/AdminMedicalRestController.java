package com.wipro.mbcms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.AdminMedicalDTO;
import com.wipro.mbcms.entities.AdminMedical;
import com.wipro.mbcms.entities.HealthcareProvider;
import com.wipro.mbcms.entities.InsurancePlans;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.services.IAdminMedicalService;
import com.wipro.mbcms.services.IHealthcareProviderService;
import com.wipro.mbcms.services.IInsurancePlansService;
import com.wipro.mbcms.services.PatientsService;

@RestController
@RequestMapping("/api/admin")
public class AdminMedicalRestController {
	
	@Autowired
	private IAdminMedicalService adminService;
	
	private IHealthcareProviderService providerService;
	
	private PatientsService patientService;
	
	private IInsurancePlansService planService;
	
	@PostMapping("/add")
	public AdminMedical addAdmin(@RequestBody AdminMedicalDTO adminDto) {
		return adminService.addAdmin(adminDto);
	}
	
	@PutMapping("/update")
	public AdminMedical updateAdmin(@RequestBody AdminMedicalDTO adminDto) {
		return adminService.updateAdmin(adminDto);
	}
	
	@GetMapping("/getAllPatients")
	public List<Patients> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/getAllProviders")
	public List<HealthcareProvider> getAllProviders() {
		return providerService.getAllProviders();
	}

	@GetMapping("/getAllInsuranecClaims")
	public List<InsuranceClaims> getAllInsuranceClaims() {
		return claimService.getAllInsuranceClaims();
	}

	@GetMapping("/getAllInsurancePlans")
	public List<InsurancePlans> getAllPlans() {
		return planService.getAllPlans();
	}
}
