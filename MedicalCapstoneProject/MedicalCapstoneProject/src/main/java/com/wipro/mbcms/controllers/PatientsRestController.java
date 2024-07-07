package com.wipro.mbcms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.AuthRequest;
import com.wipro.mbcms.dto.PatientsDTO;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.exceptions.PatientIllegalArgumentsException;
import com.wipro.mbcms.exceptions.PatientNotFoundException;
import com.wipro.mbcms.services.AuthJwtService;
import com.wipro.mbcms.services.IPatientsService;

@RestController
@RequestMapping("/api/patients")
public class PatientsRestController {

	Logger logger = LoggerFactory.getLogger(PatientsRestController.class);


	@Autowired
	private IPatientsService service;
	
	@Autowired
	private AuthJwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/get/allPatients")
	@PreAuthorize("hasAuthority('ADMIN')")
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

	@PutMapping("/updatePatient")
	@PreAuthorize("hasAuthority('PATIENT')")
	public Patients updatePatient(@RequestBody PatientsDTO patientDTO) {
		return service.updatePatients(patientDTO);
	}
	
	@GetMapping("/getbyname/{patientName}")
	@PreAuthorize("hasAuthority('PROVIDER')")
	public PatientsDTO getByPatientName(@PathVariable String patientName) {
		PatientsDTO patientdto = service.getPatientByName(patientName);
		if (patientdto.getPatientName() == null) {
			logger.error("Patient with name " + patientName + " is not registered with us!!!!");
			throw new PatientNotFoundException(HttpStatus.NOT_FOUND,
					"Patient with name " + patientName + " does not exist");
		}
		return patientdto;
	}
	
	
	
	@DeleteMapping("/delete/patient/{patientId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletePatients(@PathVariable int patientId) {
		service.deletPatients(patientId);
		return "Successfully Deleted patient with id: " + patientId;
	}
	@PostMapping("/authenticate")
	public String authenticateAndGetTokent(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		String token = null;
		if (authentication.isAuthenticated()) {
			token = jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");
		}
		return token;

	}

}
