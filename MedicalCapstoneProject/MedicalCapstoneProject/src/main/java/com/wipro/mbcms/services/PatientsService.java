package com.wipro.mbcms.services;

import java.util.List;
import com.wipro.mbcms.dto.PatientsDTO;
import com.wipro.mbcms.entities.Patients;

public interface PatientsService {

	public List<Patients> getAllPatients();

	public Patients addPatients(PatientsDTO patientsDto);

	public Patients updatePatients(PatientsDTO patientsDto);

	public String deletPatients(long patientId);

	// public Patients deletePatinetById();

//	public Patients addPatients(PatientsDTO patientsdto);
//	public Patients updatepatients(PatientsDTO patientsdto);
//	public void deletePatients(long patientId);
//	public PatientsDTO getPatientByName(String patientName);
//	public List<Patients> getAllPatients();

}
