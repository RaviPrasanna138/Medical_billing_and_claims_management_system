package com.wipro.mbcms.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.mbcms.dto.AuthRequest;
import com.wipro.mbcms.dto.HealthcareProviderDTO;
import com.wipro.mbcms.entities.HealthcareProvider;
import com.wipro.mbcms.services.AuthJwtService;
import com.wipro.mbcms.services.IHealthcareProviderService;

@RestController
@RequestMapping("/api/healthcareprovider")
@CrossOrigin("http://localhost:4200")
public class HealthcareProviderRestController {
	Logger logger = LoggerFactory.getLogger(HealthcareProviderRestController.class);

	@Autowired
	private IHealthcareProviderService service;

	@Autowired
	private AuthJwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/add")
	public HealthcareProvider addProvider(@RequestBody HealthcareProviderDTO providerDto) {
		return service.addProvider(providerDto);

	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('PROVIDER')")
	public HealthcareProvider updateProvider(@RequestBody HealthcareProviderDTO providerDto) {
		return service.updateProvider(providerDto);
	}

	@GetMapping("/getall")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<HealthcareProvider> getAllProviders() {
		return service.getAllProviders();
	}

	@GetMapping("/getbyid/{providerId}")
	@PreAuthorize("hasAuthority('PROVIDER')")
	public HealthcareProvider getProviderById(@PathVariable int providerId) {
		return service.getProviderById(providerId);
	}

	@DeleteMapping("/deletebyid/{providerId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteProviderById(@PathVariable int providerId) {
		service.deleteProviderById(providerId);
		return "Provider with id " + providerId + " is deleted";
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetTokent(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		String token = null;
		if (authentication.isAuthenticated()) {
			token = jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");
		}
		return token;

	}
}
