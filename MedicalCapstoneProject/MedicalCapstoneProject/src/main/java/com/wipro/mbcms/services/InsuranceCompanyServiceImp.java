package com.wipro.mbcms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.InsuranceCompanyDTO;
import com.wipro.mbcms.entities.InsuranceCompany;
import com.wipro.mbcms.exceptions.CompanyNotRegisteredException;
import com.wipro.mbcms.repositories.InsuranceCompanyRepository;
@Service
public class InsuranceCompanyServiceImp implements IInsuranceCompanyService {
	
	@Autowired
	private InsuranceCompanyRepository comapanyRepo;
	@Override
	public List<InsuranceCompany> getAllInsuranceCompanyDetails() {
		return CompanyRepo.findAll();
		
		
	}

	@Autowired
	private InsuranceCompanyRepository CompanyRepo;
	@Override
	public InsuranceCompany addCompany(InsuranceCompanyDTO companyDto) {
		InsuranceCompany company= new InsuranceCompany();
		company.setCompanyName(companyDto.getCompanyName());
		company.setCompanyContact(companyDto.getCompanyContact());
		company.setCompanyEmail(companyDto.getCompanyEmail());
		company.setCompanyPassword(companyDto.getCompanyPassword());
		return CompanyRepo.save(company);
	}

	@Override
	public InsuranceCompany updateCompany(InsuranceCompanyDTO companyDto) {
		InsuranceCompany company= new InsuranceCompany();
		company.setCompanyId(companyDto.getCompanyId());
		company.setCompanyName(companyDto.getCompanyName());
		company.setCompanyContact(companyDto.getCompanyContact());
		company.setCompanyEmail(companyDto.getCompanyEmail());
		company.setCompanyPassword(companyDto.getCompanyPassword());
		return CompanyRepo.save(company);
	}

	

	@Override
	public void deleteCompanyById(int companyId) {
		CompanyRepo.deleteById(companyId);

	}

	@Override
	public InsuranceCompany getCompanyByName(String companyName) {
		InsuranceCompany company = comapanyRepo.findByCompanyName(companyName)
				.orElseThrow(() -> new CompanyNotRegisteredException(HttpStatus.SERVICE_UNAVAILABLE,
						"Company With name : " + companyName + " has not registered with us !!"));
		return company;
	}

}
