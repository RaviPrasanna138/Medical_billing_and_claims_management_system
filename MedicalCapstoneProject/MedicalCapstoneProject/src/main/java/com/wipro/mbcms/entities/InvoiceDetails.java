package com.wipro.mbcms.entities;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> bec26cdff4d09065301db8960e6031fb53bb5b68

import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
public class InvoiceDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceSequence")
	@SequenceGenerator(name = "invoiceSequence", initialValue = 100000)
	private int invoiceId;
	private LocalDate invoiceDate;
	@NotNull
	private double invoiceTax;
	@DecimalMax(value = "5000")
	@DecimalMin(value = "1000") 
	private double consultationFee;
	private double diagnosticsTestsFee;
	private double diagnosticsScanFee;
	private double invoiceTotalAmount;
	private double totalBillAmount;
	@OneToOne
	@JoinColumn(name="patientId")
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
	public double getDiagnoticsScanFee() {
		return diagnosticsScanFee;
	}
	public void setDiagnoticsScanFee(double diagnosticsScanFee) {
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
	public InvoiceDetails(int invoiceId, LocalDate invoiceDate, @NotNull double invoiceTax,
<<<<<<< HEAD
			@DecimalMax("5000") @DecimalMin("1000") double consultationFee, double diagnoticsTestsFee,
			double diagnoticsScanFee, double invoiceTotalAmount, double totalBillAmount, Patients patient) {
=======
			@DecimalMax("5000") @DecimalMin("1000") double consultationFee, double diagnosticsTestsFee,
			double diagnosticsScanFee, double invoiceTotalAmount, double totalBillAmount, Patients patient) {
>>>>>>> bec26cdff4d09065301db8960e6031fb53bb5b68
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
	public InvoiceDetails() {
		super();
	}
	@Override
	public String toString() {
		return "InvoiceDetails [invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", invoiceTax=" + invoiceTax
				+ ", consultationFee=" + consultationFee + ", diagnoticsTestsFee=" + diagnosticsTestsFee
				+ ", diagnosticsScanFee=" + diagnosticsScanFee + ", invoiceTotalAmount=" + invoiceTotalAmount
				+ ", totalBillAmount=" + totalBillAmount + ", patient=" + patient + "]";
	}
	
	
}
