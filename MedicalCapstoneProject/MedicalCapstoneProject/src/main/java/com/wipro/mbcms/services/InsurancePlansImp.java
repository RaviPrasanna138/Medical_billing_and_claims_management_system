package com.wipro.mbcms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.InsurancePlansDTO;
import com.wipro.mbcms.entities.InsuranceCompany;
import com.wipro.mbcms.entities.InsurancePlans;
import com.wipro.mbcms.repositories.InsuranceCompanyRepository;
import com.wipro.mbcms.repositories.InsurancePlansRepository;
@Service
public class InsurancePlansImp implements IInsurancePlansService {
	@Autowired
	private InsurancePlansRepository repo;
	
	@Autowired
	private InsuranceCompanyRepository companyRepository;
	@Override
	public InsurancePlans addInsurancePlan(InsurancePlansDTO plansdto, String companyName) {
		InsuranceCompany company= companyRepository.findByCompanyName(companyName).orElse(new InsuranceCompany());
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanID(plansdto.getPlanID());
		plans.setPlanName(plansdto.getPlanName());
		plans.setPlanCoverAmount(plansdto.getPlanCoverAmount());
		plans.setPlanDetails(plansdto.getPlanDetails());
		plans.setPlanType(plansdto.getPlanType());
		return repo.save(plans);
	}

	@Override
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansdto) {
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanID(plansdto.getPlanID());
		plans.setPlanName(plansdto.getPlanName());
		plans.setPlanCoverAmount(plansdto.getPlanCoverAmount());
		plans.setPlanDetails(plansdto.getPlanDetails());
		plans.setPlanType(plansdto.getPlanType());
		return repo.save(plans);
	}

	@Override
	public void deleteInsurancePlan(int planId) {
		repo.deleteById(planId);


	}

	@Override
	public List<InsurancePlans> getAllPlans() {
		return repo.findAll();
	}

}
