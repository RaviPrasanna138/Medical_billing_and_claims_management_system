package com.wipro.mbcms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.AdminMedicalDTO;
import com.wipro.mbcms.dto.AuthRequest;
import com.wipro.mbcms.entities.AdminMedical;
import com.wipro.mbcms.entities.HealthcareProvider;
import com.wipro.mbcms.entities.InsuranceClaims;
import com.wipro.mbcms.entities.InsurancePlans;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.services.AuthJwtService;
import com.wipro.mbcms.services.IAdminMedicalService;
import com.wipro.mbcms.services.IHealthcareProviderService;
import com.wipro.mbcms.services.IInsuranceClaimsService;
import com.wipro.mbcms.services.IInsurancePlansService;
import com.wipro.mbcms.services.IPatientsService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:4200")
public class AdminMedicalRestController {

	@Autowired
	private IAdminMedicalService adminService;

	@Autowired
	private IHealthcareProviderService providerService;

	@Autowired
	private IInsuranceClaimsService claimService;

	@Autowired
	private IPatientsService patientService;

	@Autowired
	private IInsurancePlansService planService;

	@Autowired
	private AuthJwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	Logger logger = LoggerFactory.getLogger(AdminMedicalRestController.class);

	@PostMapping("/add")
	public AdminMedical addAdmin(@RequestBody AdminMedicalDTO adminDto) {
		return adminService.addAdmin(adminDto);
	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('ADMIN')")
	public AdminMedical updateAdmin(@RequestBody AdminMedicalDTO adminDto) {
		return adminService.updateAdmin(adminDto);
	}

	@GetMapping("/getallpatients")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Patients> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/getallproviders")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<HealthcareProvider> getAllProviders() {
		return providerService.getAllProviders();
	}

	@GetMapping("/getallinsuranecclaims")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InsuranceClaims> getAllInsuranceClaims() {
		return claimService.getAllInsuranceClaims();
	}

	@GetMapping("/getallinsuranceplans")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InsurancePlans> getAllPlans() {
		return planService.getAllPlans();
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetTokent(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		String token = null;
		if (authentication.isAuthenticated()) {
			token = jwtService.generateToken(authRequest.getUserName());
			logger.info("Token:"+ token);
		} else {
			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");
		}
		return token;

	}
}
