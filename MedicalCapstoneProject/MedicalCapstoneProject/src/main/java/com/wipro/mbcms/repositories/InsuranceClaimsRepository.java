package com.wipro.mbcms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.mbcms.entities.InsuranceClaims;

@Repository
public interface InsuranceClaimsRepository extends JpaRepository<InsuranceClaims, Long> {
	
//	@Query("SELECT claim FROM InsuranceClaim claim WHERE claim.patient.patientName = ?1")
//	public List<InsuranceClaims> getClaimByPatientName(String patientName);

}
