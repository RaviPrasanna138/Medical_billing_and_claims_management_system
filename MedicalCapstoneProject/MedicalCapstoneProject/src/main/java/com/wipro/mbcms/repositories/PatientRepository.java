package com.wipro.mbcms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.mbcms.entities.Patients;
@Repository
public interface PatientRepository extends JpaRepository<Patients, Long> {
	
}
