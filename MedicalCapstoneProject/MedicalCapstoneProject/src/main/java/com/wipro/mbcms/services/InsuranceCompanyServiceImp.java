package com.wipro.mbcms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.InsuranceCompanyDTO;
import com.wipro.mbcms.entities.InsuranceCompany;
import com.wipro.mbcms.repositories.InsuranceCompanyRepository;
@Service
public class InsuranceCompanyServiceImp implements IInsuranceCompanyService {

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
	public List<InsuranceCompany> getAllInsuranceCompanyDetails() {
		return CompanyRepo.findAll();
		
		
	}

	@Override
	public void deleteCompanyById(int companyId) {
		CompanyRepo.deleteById(companyId);

	}

	@Override
	public InsuranceCompanyDTO getCompanyByName(String companyName) {
		return null;
	}

}
