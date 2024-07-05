package com.wipro.mbcms.entities;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;
	@NotBlank
	private String patientName;
	@Email
	private String patientEmail;
	private String patientPassword;
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Letter must be 5")
	private LocalDate patientDateOfBirth;
	@NotBlank
	private String patientGender;
	private long patientMobileNumber;
	private String patientAddress;
	@NotBlank
	private String patientSymptoms;
//	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
//	private InsuranceClaims insuranceClaim;
//	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
//	private InvoiceDetails invoicedetails;

	private final static String role = "PATIENTS";

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public LocalDate getPatientDateOfBirth() {
		return patientDateOfBirth;
	}

	public void setPatientDateOfBirth(LocalDate patientDateOfBirth) {
		this.patientDateOfBirth = patientDateOfBirth;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public long getPatientMobileNumber() {
		return patientMobileNumber;
	}

	public void setPatientMobileNumber(long patientMobileNumber) {
		this.patientMobileNumber = patientMobileNumber;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientSymptoms() {
		return patientSymptoms;
	}

	public void setPatientSymptoms(String patientSymptoms) {
		this.patientSymptoms = patientSymptoms;
	}

//	public InsuranceClaims getInsuranceClaim() {
//		return insuranceClaim;
//	}
//
//	public void setInsuranceClaim(InsuranceClaims insuranceClaim) {
//		this.insuranceClaim = insuranceClaim;
//	}
//
//	public InvoiceDetails getInvoicedetails() {
//		return invoicedetails;
//	}
//
//	public void setInvoicedetails(InvoiceDetails invoicedetails) {
//		this.invoicedetails = invoicedetails;
//	}

	public static String getRole() {
		return role;
	}

	public Patients(long patientId, @NotBlank String patientName, @Email String patientEmail, String patientPassword,
			@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Letter must be 5") LocalDate patientDateOfBirth,
			@NotBlank String patientGender, long patientMobileNumber, String patientAddress,
			@NotBlank String patientSymptoms, InsuranceClaims insuranceClaim, InvoiceDetails invoicedetails) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientPassword = patientPassword;
		this.patientDateOfBirth = patientDateOfBirth;
		this.patientGender = patientGender;
		this.patientMobileNumber = patientMobileNumber;
		this.patientAddress = patientAddress;
		this.patientSymptoms = patientSymptoms;
//		this.insuranceClaim = insuranceClaim;
//		this.invoicedetails = invoicedetails;
	}

	public Patients() {
		super();
	}

	@Override
	public String toString() {
		return "Patients [patientId=" + patientId + ", patientName=" + patientName + ", patientEmail=" + patientEmail
				+ ", patientPassword=" + patientPassword + ", patientDateOfBirth=" + patientDateOfBirth
				+ ", patientGender=" + patientGender + ", patientMobileNumber=" + patientMobileNumber
				+ ", patientAddress=" + patientAddress + ", patientSymptoms=" + patientSymptoms + "]";
	}

}
