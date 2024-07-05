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
	private InsurancePlansRepository planRepo;
	
	@Autowired
	private InsuranceCompanyRepository companyRepo;
	@Override
	public InsurancePlans addInsurancePlan(InsurancePlansDTO plansDto, String companyName) {
		InsuranceCompany company= companyRepo.findByCompanyName(companyName).orElse(new InsuranceCompany());
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanID(plansDto.getPlanID());
		plans.setPlanName(plansDto.getPlanName());
		plans.setPlanCoverAmount(plansDto.getPlanCoverAmount());
		plans.setPlanDetails(plansDto.getPlanDetails());
		plans.setPlanType(plansDto.getPlanType());
		return planRepo.save(plans);
	}

	@Override
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansDto) {
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanID(plansDto.getPlanID());
		plans.setPlanName(plansDto.getPlanName());
		plans.setPlanCoverAmount(plansDto.getPlanCoverAmount());
		plans.setPlanDetails(plansDto.getPlanDetails());
		plans.setPlanType(plansDto.getPlanType());
		return planRepo.save(plans);
	}

	@Override
	public void deleteInsurancePlan(int planId) {
		planRepo.deleteById(planId);


	}

	@Override
	public List<InsurancePlans> getAllPlans() {
		return planRepo.findAll();
	}

}
