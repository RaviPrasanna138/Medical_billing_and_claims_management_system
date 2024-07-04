package com.wipro.mbcms.dto;

import com.wipro.mbcms.entities.InsurancePlans;
import com.wipro.mbcms.entities.Patients;


public class InsuranceClaimsDTO {

	private long claimId;

	private double claimAmount;
	private String claimStatus;
	
	private double invoiceAmount;
	
	private Patients patient;
	
	private InsurancePlans plans;

	public long getClaimId() {
		return claimId;
	}

	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Patients getPatient() {
		return patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}

	public InsurancePlans getPlans() {
		return plans;
	}

	public void setPlans(InsurancePlans plans) {
		this.plans = plans;
	}

	public InsuranceClaimsDTO(long claimId, double claimAmount,
			String claimStatus, double invoiceAmount, Patients patient,
			InsurancePlans plans)
	{
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.invoiceAmount = invoiceAmount;
		this.patient = patient;
		this.plans = plans;
	}

	public InsuranceClaimsDTO() {
		super();
	}

	@Override
	public String toString() {
		return "InsuranceClaims [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus
				+ ", invoiceAmount=" + invoiceAmount + ", patient=" + patient + ", plans=" + plans + "]";
	}

}
