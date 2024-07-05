package com.wipro.mbcms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.PatientsDTO;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.repositories.PatientRepository;

@Service
public class PatientsServiceImp implements IPatientsService {
	@Autowired
	PatientRepository repo;

	@Override
	public List<Patients> getAllPatients() {
		return repo.findAll();
	}

	@Override
	public Patients addPatients(PatientsDTO patientsDto) {

		Patients patient = new Patients();
		patient.setPatientName(patientsDto.getPatientName());
		patient.setPatientPassword(patientsDto.getPatientPassword());
		patient.setPatientDateOfBirth(patientsDto.getPatientDateOfBirth());
		patient.setPatientGender(patientsDto.getPatientGender());
		patient.setPatientMobileNumber(patientsDto.getPatientMobileNumber());
		patient.setPatientAddress(patientsDto.getPatientAddress());
		patient.setPatientSymptoms(patientsDto.getPatientSymptoms());
//		patient.setInsuranceClaim(patientsDto.getInsuranceClaim());
//		patient.setInvoicedetails(patientsDto.getInvoicedetails());

		return repo.save(patient);
	}

	@Override
	public Patients updatePatients(PatientsDTO patientsDto) {
		Patients patient = new Patients();
		patient.setPatientId(patientsDto.getPatientId());
		patient.setPatientName(patientsDto.getPatientName());
		patient.setPatientPassword(patientsDto.getPatientPassword());
		patient.setPatientDateOfBirth(patientsDto.getPatientDateOfBirth());
		patient.setPatientGender(patientsDto.getPatientGender());
		patient.setPatientMobileNumber(patientsDto.getPatientMobileNumber());
		patient.setPatientAddress(patientsDto.getPatientAddress());
		patient.setPatientSymptoms(patientsDto.getPatientSymptoms());
//		patient.setInsuranceClaim(patientsDto.getInsuranceClaim());
//		patient.setInvoicedetails(patientsDto.getInvoicedetails());
		return repo.save(patient);

	}

	@Override
	public String deletPatients(long patientId) {
		repo.deleteById(patientId);

		return "one record affected " + patientId + " record deleted";
	}

}
