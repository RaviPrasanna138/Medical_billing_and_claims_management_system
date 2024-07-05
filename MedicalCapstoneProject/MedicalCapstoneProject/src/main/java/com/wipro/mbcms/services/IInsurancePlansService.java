package com.wipro.mbcms.services;

import java.util.List;

import com.wipro.mbcms.dto.InsurancePlansDTO;
import com.wipro.mbcms.entities.InsurancePlans;

public interface IInsurancePlansService {
    public InsurancePlans addInsurancePlan(InsurancePlansDTO plansDto,String companyName);
	
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansDto);
	 
	public void deleteInsurancePlan(int planId);
	
	public List<InsurancePlans> getAllPlans();
	
	public List<InsurancePlans> getPlansByCompanyName(String companyName);
}
