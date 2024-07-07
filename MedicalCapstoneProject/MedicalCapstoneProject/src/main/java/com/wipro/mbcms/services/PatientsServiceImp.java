package com.wipro.mbcms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.PatientsDTO;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.repositories.PatientRepository;

@Service
public class PatientsServiceImp implements IPatientsService {
	@Autowired
	PatientRepository repo;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public List<Patients> getAllPatients() {
		return repo.findAll();
	}

	@Override
	public Patients addPatients(PatientsDTO patientsDto) {

		Patients patient = new Patients();
		patient.setPatientName(patientsDto.getPatientName());
		patient.setPatientPassword(encoder.encode(patientsDto.getPatientPassword()));
		patient.setPatientEmail(patientsDto.getPatientEmail());
		patient.setPatientDateOfBirth(patientsDto.getPatientDateOfBirth());
		patient.setPatientGender(patientsDto.getPatientGender());
		patient.setPatientMobileNumber(patientsDto.getPatientMobileNumber());
		patient.setPatientAddress(patientsDto.getPatientAddress());
		patient.setPatientSymptoms(patientsDto.getPatientSymptoms());
		patient.setPatientTreatment(patientsDto.getPatientTreatment());
		return repo.save(patient);
	}

	@Override
	public Patients updatePatients(PatientsDTO patientsDto) {
		Patients patient = new Patients();
		patient.setPatientId(patientsDto.getPatientId());
		patient.setPatientName(patientsDto.getPatientName());
		patient.setPatientPassword(encoder.encode(patientsDto.getPatientPassword()));
		patient.setPatientEmail(patientsDto.getPatientEmail());
		patient.setPatientDateOfBirth(patientsDto.getPatientDateOfBirth());
		patient.setPatientGender(patientsDto.getPatientGender());
		patient.setPatientMobileNumber(patientsDto.getPatientMobileNumber());
		patient.setPatientAddress(patientsDto.getPatientAddress());
		patient.setPatientSymptoms(patientsDto.getPatientSymptoms());
		patient.setPatientTreatment(patientsDto.getPatientTreatment());
		return repo.save(patient);

	}
	public PatientsDTO getPatientByName(String patientName) {
		Patients patient = repo.findByPatientName(patientName).orElse(new Patients());
		PatientsDTO patientdto = new PatientsDTO();
		patientdto.setPatientId(patient.getPatientId());
		patientdto.setPatientName(patient.getPatientName());
		patientdto.setPatientDateOfBirth(patient.getPatientDateOfBirth());
		patientdto.setPatientGender(patient.getPatientGender());
		patientdto.setPatientMobileNumber(patient.getPatientMobileNumber());
		patientdto.setPatientAddress(patient.getPatientAddress());
		patientdto.setPatientSymptoms(patient.getPatientSymptoms());
		patientdto.setPatientTreatment(patient.getPatientTreatment());
		return patientdto;
	}

	@Override
	public String deletPatients(long patientId) {
		repo.deleteById(patientId);

		return "one record affected " + patientId + " record deleted";
	}

}
