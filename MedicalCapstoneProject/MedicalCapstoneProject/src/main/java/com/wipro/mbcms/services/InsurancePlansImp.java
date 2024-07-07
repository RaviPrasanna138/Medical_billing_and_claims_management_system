package com.wipro.mbcms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.InsurancePlansDTO;
import com.wipro.mbcms.entities.InsuranceCompany;
import com.wipro.mbcms.entities.InsurancePlans;
import com.wipro.mbcms.repositories.InsuranceCompanyRepository;
import com.wipro.mbcms.repositories.InsurancePlansRepository;
@Service
public class InsurancePlansImp implements IInsurancePlansService {
	
	Logger logger = LoggerFactory.getLogger(InsurancePlansImp.class);
	@Autowired
	private InsurancePlansRepository planRepo;
	
	@Autowired
	private InsuranceCompanyRepository companyRepo;
	@Override
	public InsurancePlans addInsurancePlan(InsurancePlansDTO plansDto, String companyName) {
		InsuranceCompany company= companyRepo.findByCompanyName(companyName).orElseThrow(null);
		InsurancePlans plans = new InsurancePlans();
		plans.setPlanID(plansDto.getPlanID());
		plans.setPlanName(plansDto.getPlanName());
		plans.setPlanCoverAmount(plansDto.getPlanCoverAmount());
		plans.setPlanDetails(plansDto.getPlanDetails());
		plans.setPlanType(plansDto.getPlanType());
		plans.setCompany(company);
		logger.info("New Insurance Plan Added");
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
		logger.warn("Insurance Plan Updated ");
		return planRepo.save(plans);
	}

	@Override
	public void deleteInsurancePlan(int planId) {
		logger.warn("Insurance Plans"+planId+"Deleted");
		planRepo.deleteById(planId);


	}

	@Override
	public List<InsurancePlans> getAllPlans() {
		logger.info("All The Insurance Plans Are Dispalyed");
		return planRepo.findAll();
	}

	@Override
	public List<InsurancePlans> getPlansByCompanyName(String companyName) {
		logger.info("All the Insurance Plans by Company Name");
		return planRepo.findByCompanyName(companyName);
	}

}
