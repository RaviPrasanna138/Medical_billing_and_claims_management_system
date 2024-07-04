package com.wipro.mbcms.services;

import java.util.List;

import com.wipro.mbcms.dto.InsuranceCompanyDTO;
import com.wipro.mbcms.entities.InsuranceCompany;

public interface IInsuranceCompanyService {
	public InsuranceCompany addCompany(InsuranceCompanyDTO companydto);

	public InsuranceCompany updateCompany(InsuranceCompanyDTO companydto);

	public List<InsuranceCompany> getAllInsuranceCompanyDetails();

	public void deleteCompanyById(int companyId);

	public InsuranceCompanyDTO getCompanyByName(String companyName);
	
	

	
	

}
