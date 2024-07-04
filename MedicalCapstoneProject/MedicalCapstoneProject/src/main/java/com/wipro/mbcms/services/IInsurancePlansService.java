package com.wipro.mbcms.services;

import java.util.List;

import com.wipro.mbcms.dto.InsurancePlansDTO;
import com.wipro.mbcms.entities.InsurancePlans;

public interface IInsurancePlansService {
    public InsurancePlans addInsurancePlan(InsurancePlansDTO plansdto,String companyName);
	
	public InsurancePlans updateInsurancePlans(InsurancePlansDTO plansdto);
	 
	public void deleteInsurancePlan(int planId);
	
	public List<InsurancePlans> getAllPlans();
	

}
