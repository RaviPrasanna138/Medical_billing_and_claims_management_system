package com.wipro.mbcms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.InsuranceCompanyDTO;
import com.wipro.mbcms.entities.InsuranceCompany;
import com.wipro.mbcms.services.IInsuranceCompanyService;

@RestController
@RequestMapping("/api/insurancecompany")
public class InsuranceCompanyRestController {
	@Autowired
	private IInsuranceCompanyService service;
	
	@PostMapping("/add/company")
	public InsuranceCompany addNewCompany(@RequestBody InsuranceCompanyDTO companyDTO) {
		return service.addCompany(companyDTO);
	}
	
	@PutMapping("/update/company/{companyId}")
	public InsuranceCompany updateExistingCompany(@RequestBody InsuranceCompanyDTO companyDTO,@PathVariable int companyId) {
		return service.updateCompany(companyDTO);
	}

	@DeleteMapping("/delete/companyById/{companyId}")
	public String deleteExistingCompany(@PathVariable int companyId) {
		service.deleteCompanyById(companyId);
		return "Insurance Company with id " + companyId + " is deleted";
	}
	
	@GetMapping("/getbycompanyname/{companyName}")
	public InsuranceCompany getCompanyByName(@PathVariable String companyName) {
		return service.getCompanyByName(companyName);

	}
	

	@GetMapping("/getallcompaniesdata")
	public List<InsuranceCompany> getAllInsuranceCompanies() {
		return service.getAllInsuranceCompanyDetails();
	}
}

