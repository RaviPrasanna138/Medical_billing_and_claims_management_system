package com.wipro.mbcms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.PatientsDTO;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.exceptions.PatientIllegalArgumentsException;
import com.wipro.mbcms.services.IInsurancePlansService;
import com.wipro.mbcms.services.IPatientsService;

@RestController
@RequestMapping("/api/patients")
public class PatientsRestController {

	Logger logger = LoggerFactory.getLogger(PatientsRestController.class);


	@Autowired
	private IPatientsService service;
	
	
	@GetMapping("/get/allPatients")
	public List<Patients> getAllPatients() {
		return service.getAllPatients();
	}

	@PostMapping("/addPatients")
	public Patients insertPatients(@RequestBody PatientsDTO patientDTO) {

		Patients patient = service.addPatients(patientDTO);

		if (patient.getPatientName() == null || patient.getPatientGender() == null) {
			logger.error("Patient has entered wrong data!!!");
			throw new PatientIllegalArgumentsException(HttpStatus.BAD_REQUEST, "You have entered Invalid values.");
		}
		return patient;
	}

	@PutMapping("/updatePatient/{patientId}")
	public Patients updatePatient(@RequestBody PatientsDTO patientDTO, @PathVariable long patientId) {
		return service.updatePatients(patientDTO);
	}
	
	
	
	@DeleteMapping("/delete/patient/{patientId}")
	public String deletePatients(@PathVariable int patientId) {
		service.deletPatients(patientId);
		return "Successfully Deleted patient with id: " + patientId;
	}

}
