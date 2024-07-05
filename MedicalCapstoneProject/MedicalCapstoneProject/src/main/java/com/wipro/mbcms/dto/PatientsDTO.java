package com.wipro.mbcms.dto;

import java.util.Date;

public class PatientsDTO {
	
	private long patientId;
	private String patientName;
	private String patientPassword;
	private Date patientDateOfBirth;
	private String patientGender;
	private long patientMobileNumber;
	private String patientAddress;
	private String patientSymptoms;
	private String patientTreatment;

	public PatientsDTO() {
		super();
	}

	public PatientsDTO(long patientId, String patientName, String patientPassword, Date patientDateOfBirth,
			String patientGender, long patientMobileNumber, String patientAddress, String patientSymptoms,
			String patientTreatment) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientPassword = patientPassword;
		this.patientDateOfBirth = patientDateOfBirth;
		this.patientGender = patientGender;
		this.patientMobileNumber = patientMobileNumber;
		this.patientAddress = patientAddress;
		this.patientSymptoms = patientSymptoms;
		this.patientTreatment = patientTreatment;
	}
	

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

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public Date getPatientDateOfBirth() {
		return patientDateOfBirth;
	}

	public void setPatientDateOfBirth(Date patientDateOfBirth) {
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

	public String getPatientTreatment() {
		return patientTreatment;
	}

	public void setPatientTreatment(String patientTreatment) {
		this.patientTreatment = patientTreatment;
	}

	@Override
	public String toString() {
		return "Patients [patientId=" + patientId + ", patientName=" + patientName + ", patientPassword="
				+ patientPassword + ", patientDateOfBirth=" + patientDateOfBirth + ", patientGender=" + patientGender
				+ ", patientMobileNumber=" + patientMobileNumber + ", patientAddress=" + patientAddress
				+ ", patientSymptoms=" + patientSymptoms + ", patientTreatment=" + patientTreatment + "]";
	}

}
