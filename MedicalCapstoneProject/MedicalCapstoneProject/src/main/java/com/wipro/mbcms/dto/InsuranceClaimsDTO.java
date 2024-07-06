package com.wipro.mbcms.dto;

public class InsuranceClaimsDTO {

	private long claimId;
	private double claimAmount;
	private String claimStatus;
	private double invoiceAmount;

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


	public InsuranceClaimsDTO(long claimId, double claimAmount,
			String claimStatus, double invoiceAmount)
	{
		super();
		this.claimId = claimId;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.invoiceAmount = invoiceAmount;
	}

	public InsuranceClaimsDTO() {
		super();
	}

	@Override
	public String toString() {
		return "InsuranceClaims [claimId=" + claimId + ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus
				+ ", invoiceAmount=" + invoiceAmount  + "]";
	}

}
