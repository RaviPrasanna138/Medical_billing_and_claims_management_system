package com.wipro.mbcms.dto;

import java.time.LocalDate;

import com.wipro.mbcms.entities.Patients;

public class InvoiceDetailsDTO {
	private int invoiceId;
	private LocalDate invoiceDate;
	private double invoiceTax;
	private double consultationFee;
	private double diagnosticsTestsFee;
	private double diagnosticsScanFee;
	private double invoiceTotalAmount;
	private double totalBillAmount;
	private Patients patient;
	
	
	public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}


	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public double getInvoiceTax() {
		return invoiceTax;
	}


	public void setInvoiceTax(double invoiceTax) {
		this.invoiceTax = invoiceTax;
	}


	public double getConsultationFee() {
		return consultationFee;
	}


	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}


	public double getDiagnosticsTestsFee() {
		return diagnosticsTestsFee;
	}


	public void setDiagnosticsTestsFee(double diagnosticsTestsFee) {
		this.diagnosticsTestsFee = diagnosticsTestsFee;
	}


	public double getDiagnosticsScanFee() {
		return diagnosticsScanFee;
	}


	public void setDiagnosticsScanFee(double diagnosticsScanFee) {
		this.diagnosticsScanFee = diagnosticsScanFee;
	}


	public double getInvoiceTotalAmount() {
		return invoiceTotalAmount;
	}


	public void setInvoiceTotalAmount(double invoiceTotalAmount) {
		this.invoiceTotalAmount = invoiceTotalAmount;
	}


	public double getTotalBillAmount() {
		return totalBillAmount;
	}


	public void setTotalBillAmount(double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}


	public Patients getPatient() {
		return patient;
	}


	public void setPatient(Patients patient) {
		this.patient = patient;
	}


	public InvoiceDetailsDTO(int invoiceId, LocalDate invoiceDate, double invoiceTax, double consultationFee,
			double diagnosticsTestsFee, double diagnosticsScanFee, double invoiceTotalAmount, double totalBillAmount,
			Patients patient) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.invoiceTax = invoiceTax;
		this.consultationFee = consultationFee;
		this.diagnosticsTestsFee = diagnosticsTestsFee;
		this.diagnosticsScanFee = diagnosticsScanFee;
		this.invoiceTotalAmount = invoiceTotalAmount;
		this.totalBillAmount = totalBillAmount;
		this.patient = patient;
	}


	public InvoiceDetailsDTO() {
		super();
	}


	@Override
	public String toString() {
		return "InvoiceDetailsDTO [invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", invoiceTax="
				+ invoiceTax + ", consultationFee=" + consultationFee + ", diagnosticsTestsFee=" + diagnosticsTestsFee
				+ ", diagnosticsScanFee=" + diagnosticsScanFee + ", invoiceTotalAmount=" + invoiceTotalAmount
				+ ", totalBillAmount=" + totalBillAmount + ", patient=" + patient + "]";
	}
	
}
