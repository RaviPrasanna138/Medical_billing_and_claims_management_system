package com.wipro.mbcms.services;

import java.util.List;

import com.wipro.mbcms.dto.HealthcareProviderDTO;
import com.wipro.mbcms.entities.HealthcareProvider;

public interface IHealthcareProviderService {

	public HealthcareProvider addProvider(HealthcareProviderDTO providerDto);

	public HealthcareProvider updateProvider(HealthcareProviderDTO providerDto);

	public List<HealthcareProvider> getAllProviders();

	public HealthcareProvider getProviderById(int providerId);
	
	public void deleteProviderById(int providerId);
}
