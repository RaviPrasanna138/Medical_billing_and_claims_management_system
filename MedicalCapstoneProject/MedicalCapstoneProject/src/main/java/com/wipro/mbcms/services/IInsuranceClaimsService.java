package com.wipro.mbcms.services;

import java.util.List;
import java.util.Optional;

import com.wipro.mbcms.dto.InsuranceClaimsDTO;
import com.wipro.mbcms.entities.InsuranceClaims;

public interface IInsuranceClaimsService {

	public List<InsuranceClaims> getAllInsuranceClaims();

	public InsuranceClaims addClaims(InsuranceClaimsDTO claimDto, String patientName, int planId);

	public InsuranceClaims updateClaims(InsuranceClaimsDTO claimsDto, long claimId);

	public InsuranceClaims getById(long claimId);

//	public List<InsuranceClaims> getClaimByPatientName(String patientName);

}
