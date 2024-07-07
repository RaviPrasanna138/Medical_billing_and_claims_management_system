package com.wipro.mbcms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
public class InsurancePlans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planID;
	@NotBlank
	private String planName;
	private String planType;
	@DecimalMax(value = "1000000")
	@DecimalMin(value = "100000")
	private double planCoverAmount;
	private String planDetails;
	@ManyToOne
	@JoinColumn(name = "companyId")
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

	public InsurancePlans(int planID, @NotBlank String planName, String planType,
			@DecimalMax("10000000") @DecimalMin("1000000") double planCoverAmount, String planDetails,
			InsuranceCompany company) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.planType = planType;
		this.planCoverAmount = planCoverAmount;
		this.planDetails = planDetails;
		this.company = company;
	}

	public InsurancePlans() {
		super();
	}

	@Override
	public String toString() {
		return "InsurancePlans [planID=" + planID + ", planName=" + planName + ", planType=" + planType
				+ ", planCoverAmount=" + planCoverAmount + ", planDetails=" + planDetails + ", company=" + company
				+ "]";
	}

}
