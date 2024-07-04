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
	private InsuranceCompanyRepository repo;
	@Override
	public InsuranceCompany addCompany(InsuranceCompanyDTO companydto) {
		InsuranceCompany company= new InsuranceCompany();
		company.setCompanyName(companydto.getCompanyName());
		company.setCompanyContact(companydto.getCompanyContact());
		company.setCompanyEmail(company.getCompanyEmail());
		company.setCompanyPassword(companydto.getCompanyPassword());
		return repo.save(company);
	}

	@Override
	public InsuranceCompany updateCompany(InsuranceCompanyDTO companydto) {
		InsuranceCompany company= new InsuranceCompany();
		company.setCompanyId(companydto.getCompanyId());
		company.setCompanyName(companydto.getCompanyName());
		company.setCompanyContact(companydto.getCompanyContact());
		company.setCompanyEmail(company.getCompanyEmail());
		company.setCompanyPassword(companydto.getCompanyPassword());
		return repo.save(company);
	}

	@Override
	public List<InsuranceCompany> getAllInsuranceCompanyDetails() {
		return repo.findAll();
		
		
	}

	@Override
	public void deleteCompanyById(int companyId) {
		repo.deleteById(companyId);

	}

	@Override
	public InsuranceCompanyDTO getCompanyByName(String companyName) {
		return null;
	}

}
