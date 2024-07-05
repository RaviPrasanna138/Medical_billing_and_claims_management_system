package com.wipro.mbcms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.mbcms.entities.InsuranceClaims;

@Repository
public interface InsuranceClaimsRepository extends JpaRepository<InsuranceClaims, Long> {
	
	@Query("SELECT claim FROM InsuranceClaims WHERE claim.patientName=?1")
	public List<InsuranceClaims> getClaimByPatientName(String patientName);

}
