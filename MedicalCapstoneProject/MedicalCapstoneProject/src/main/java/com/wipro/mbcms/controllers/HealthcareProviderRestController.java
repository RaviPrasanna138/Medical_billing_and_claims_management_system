package com.wipro.mbcms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.HealthcareProviderDTO;
import com.wipro.mbcms.entities.HealthcareProvider;
import com.wipro.mbcms.services.IHealthcareProviderService;

@RestController
@RequestMapping("/api/healthcareprovider")
public class HealthcareProviderRestController {
	Logger logger = LoggerFactory.getLogger(HealthcareProviderRestController.class);
	
	@Autowired
	private IHealthcareProviderService service;
	
	@PostMapping("/add")
	public HealthcareProvider addProvider(@RequestBody HealthcareProviderDTO providerDto) {
		return service.addProvider(providerDto);
		
	}
	
	@PutMapping("/update")
	public HealthcareProvider updateProvider(@RequestBody HealthcareProviderDTO providerDto) {
		return service.updateProvider(providerDto);
	}

	@GetMapping("/getAll")
	public List<HealthcareProvider> getAllProviders(){
		return service.getAllProviders();
	}
	
	@GetMapping("/getById/{providerId}")
	public HealthcareProvider getProviderById(@PathVariable int providerId) {
		return service.getProviderById(providerId);
	}
	
	@DeleteMapping("/deleteById/{provideId}")
	public String deleteProviderById(@PathVariable int providerId) {
		service.deleteProviderById(providerId);
		return "Provider with id " + providerId + " is deleted";
	}
}
