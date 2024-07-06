package com.wipro.mbcms.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class HealthcareProvider {
	@Id
	@SequenceGenerator(name = "providerSequence", initialValue = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "providerSequence")
	private int providerId;
	@NotBlank
	private String providerName;
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Letter must be 5")
	private String providerPassword;
	@Email
	private String providerEmail;
	private String providerSpeciality;
	private final static String role = "PROVIDER";

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderPassword() {
		return providerPassword;
	}

	public void setProviderPassword(String providerPassword) {
		this.providerPassword = providerPassword;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getProviderSpeciality() {
		return providerSpeciality;
	}

	public void setProviderSpeciality(String providerSpeciality) {
		this.providerSpeciality = providerSpeciality;
	}

	public static String getRole() {
		return role;
	}

	public HealthcareProvider(int providerId, @NotBlank String providerName,
			@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Letter must be 5") String providerPassword,
			@Email String providerEmail, @NotBlank String providerSpeciality) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerPassword = providerPassword;
		this.providerEmail = providerEmail;
		this.providerSpeciality = providerSpeciality;
	}

	public HealthcareProvider() {
		super();
	}

	@Override
	public String toString() {
		return "HealthcareProvider [providerId=" + providerId + ", providerName=" + providerName + ", providerPassword="
				+ providerPassword + ", providerEmail=" + providerEmail + ", providerSpeciality=" + providerSpeciality
				+ "]";
	}

}
