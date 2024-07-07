package com.wipro.mbcms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.AuthRequest;
import com.wipro.mbcms.dto.InsuranceCompanyDTO;
import com.wipro.mbcms.entities.InsuranceCompany;
import com.wipro.mbcms.services.AuthJwtService;
import com.wipro.mbcms.services.IInsuranceCompanyService;

@RestController
@RequestMapping("/api/insurancecompany")
public class InsuranceCompanyRestController {
	@Autowired
	private IInsuranceCompanyService service;
	
	@Autowired
	private AuthJwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/add/company")
	public InsuranceCompany addNewCompany(@RequestBody InsuranceCompanyDTO companyDTO) {
		return service.addCompany(companyDTO);
	}
	
	@PutMapping("/update/company/{companyId}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsuranceCompany updateExistingCompany(@RequestBody InsuranceCompanyDTO companyDTO,@PathVariable int companyId) {
		return service.updateCompany(companyDTO);
	}

	@DeleteMapping("/delete/companyById/{companyId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteExistingCompany(@PathVariable int companyId) {
		service.deleteCompanyById(companyId);
		return "Insurance Company with id " + companyId + " is deleted";
	}
	
	@GetMapping("/getbycompanyname/{companyName}")
	@PreAuthorize("hasAuthority('COMPANY')")
	public InsuranceCompany getCompanyByName(@PathVariable String companyName) {
		return service.getCompanyByName(companyName);

	}
	

	@GetMapping("/getallcompaniesdata")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<InsuranceCompany> getAllInsuranceCompanies() {
		return service.getAllInsuranceCompanyDetails();
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetTokent(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		String token = null;
		if (authentication.isAuthenticated()) {
			token = jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");
		}
		return token;

	}
}

