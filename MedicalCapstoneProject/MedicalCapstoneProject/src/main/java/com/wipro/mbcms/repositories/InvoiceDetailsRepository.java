package com.wipro.mbcms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.mbcms.entities.InvoiceDetails;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Integer> {
	@Query("select i from InvoiceDetails i where i.patient.patientName=?1")
	List<InvoiceDetails> getByPatientName(String patientName);

}
