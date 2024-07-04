package com.wipro.mbcms.dto;

import com.wipro.mbcms.entities.InsuranceCompany;

public class InsurancePlansDTO {
	private int planID;
	private String planName;
	private String planType;
	private double planCoverAmount;
	private String planDetails;
	private InsuranceCompany company;

	public int getPlanID() {
		return planID;
	}

	public void setPlanID(int planID) {
		this.planID = planID;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public double getPlanCoverAmount() {
		return planCoverAmount;
	}

	public void setPlanCoverAmount(double planCoverAmount) {
		this.planCoverAmount = planCoverAmount;
	}

	public String getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(String planDetails) {
		this.planDetails = planDetails;
	}

	public InsuranceCompany getCompany() {
		return company;
	}

	public void setCompany(InsuranceCompany company) {
		this.company = company;
	}

}
