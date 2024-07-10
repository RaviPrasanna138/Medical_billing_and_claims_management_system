package com.wipro.mbcms.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.InsuranceCompanyDTO;
import com.wipro.mbcms.entities.InsuranceCompany;
@Service
public interface IInsuranceCompanyService {
	
	public InsuranceCompany addCompany(InsuranceCompanyDTO companyDto);

	public InsuranceCompany updateCompany(InsuranceCompanyDTO companyDto);

	public List<InsuranceCompany> getAllInsuranceCompanyDetails();

	public void deleteCompanyById(int companyId);

	public InsuranceCompanyDTO getCompanyByName(String companyName);

}
