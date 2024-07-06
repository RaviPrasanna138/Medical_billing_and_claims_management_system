package com.wipro.mbcms.services;

import java.util.List;
import com.wipro.mbcms.dto.PatientsDTO;
import com.wipro.mbcms.entities.Patients;

public interface IPatientsService {

	public List<Patients> getAllPatients();

	public Patients addPatients(PatientsDTO patientsDto);

	public Patients updatePatients(PatientsDTO patientsDto);
	
	public PatientsDTO getPatientByName(String patientName);

	public String deletPatients(long patientId);
	

}
