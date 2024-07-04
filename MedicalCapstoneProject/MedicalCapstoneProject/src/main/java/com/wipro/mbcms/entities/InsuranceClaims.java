package com.wipro.mbcms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

@Entity
public class InsuranceClaims {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claimSequence")
	@SequenceGenerator(name = "claimSequence", initialValue = 1000)
	private long claimId;
	@DecimalMin(value = "200000")
	@DecimalMax(value = "800000")
	private double claimAmount;
	private String claimStatus;
	@DecimalMin(value = "50000")
	@DecimalMax(value = "800000")
	private double invoiceAmount;
	@OneToOne
	@JoinColumn(name = "patientId")
	private Patients patient;
	@OneToOne
	@JoinColumn(name = "planId")
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

	public InsuranceClaims(long claimId, @DecimalMin("200000") @DecimalMax("800000") double claimAmount,
			String claimStatus, @DecimalMin("50000") @DecimalMax("800000") double invoiceAmount, Patients patient,
			InsurancePlans plans) {
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.invoiceAmount = invoiceAmount;
		this.patient = patient;
		this.plans = plans;
	}

	public InsuranceClaims() {
		super();
	}

	@Override
	public String toString() {
		return "InsuranceClaims [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus
				+ ", invoiceAmount=" + invoiceAmount + ", patient=" + patient + ", plans=" + plans + "]";
	}

}
