
package com.wipro.mbcms.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.InsuranceClaimsDTO;
import com.wipro.mbcms.entities.InsuranceClaims;
import com.wipro.mbcms.entities.InsurancePlans;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.exceptions.ClaimNotValidException;
import com.wipro.mbcms.repositories.InsuranceClaimsRepository;
import com.wipro.mbcms.repositories.InsurancePlansRepository;
import com.wipro.mbcms.repositories.PatientRepository;

@Service
public class InsuranceClaimsServiceImp implements IInsuranceClaimsService {

	Logger logger = LoggerFactory.getLogger(InsuranceClaimsServiceImp.class);
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private InsuranceClaimsRepository insuranceRepo;


	@Autowired

	private InsurancePlansRepository plansRepo;

	@Override
	public List<InsuranceClaims> getAllInsuranceClaims() {

		return insuranceRepo.findAll();
	}

	@Override
	public InsuranceClaims addClaims(InsuranceClaimsDTO claimDto, String patientName, int planId) {
		Patients patients = patientRepo.findByPatientName(patientName).orElse(new Patients());
		InsurancePlans plans = plansRepo.findById(planId).orElse(new InsurancePlans());
		InsuranceClaims claims = new InsuranceClaims();
		claims.setClaimAmount(claimDto.getClaimAmount());
		claims.setClaimStatus(claimDto.getClaimStatus());
		claims.setPatient(patients);
		claims.setPlans(plans);
		logger.info("Claims ");
		return insuranceRepo.save(claims);

	}

	@Override
	public InsuranceClaims updateClaims(InsuranceClaimsDTO claimsDto, long claimId) {
		Optional<InsuranceClaims> optionalClaims = insuranceRepo.findById(claimId);

		InsuranceClaims claims = new InsuranceClaims();
		if (optionalClaims.isPresent()) {
			claims = optionalClaims.get();

			claims.setClaimStatus(claimsDto.getClaimStatus());
		} else {
			logger.error("the claim id your searching for is not found!");
			throw new ClaimNotValidException(HttpStatus.BAD_REQUEST, "claim with id" + claimId + " is invalid");
		}
		return insuranceRepo.save(claims);
	}

	@Override

	public InsuranceClaims getById(long claimId) {
		return insuranceRepo.findById(claimId).orElse(null);
	}

}
