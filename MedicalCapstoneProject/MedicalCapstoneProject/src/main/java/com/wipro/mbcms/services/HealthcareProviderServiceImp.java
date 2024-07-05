package com.wipro.mbcms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.HealthcareProviderDTO;
import com.wipro.mbcms.entities.HealthcareProvider;
import com.wipro.mbcms.repositories.HealthcareProviderRepository;
@Service
public class HealthcareProviderServiceImp implements IHealthcareProviderService {

	@Autowired
	private HealthcareProviderRepository healthcareRepo;

	@Override
	public HealthcareProvider addProvider(HealthcareProviderDTO providerDto) {
		HealthcareProvider provider = new HealthcareProvider();
		provider.setProviderName(providerDto.getProviderName());
		provider.setProviderPassword(providerDto.getProviderPassword());
		provider.setProviderEmail(providerDto.getProviderEmail());
		provider.setProviderSpeciality(provider.getProviderSpeciality());
		return healthcareRepo.save(provider);
	}

	@Override
	public HealthcareProvider updateProvider(HealthcareProviderDTO providerDto) {
		HealthcareProvider provider = new HealthcareProvider();
		provider.setProviderId(providerDto.getProviderId());
		provider.setProviderName(providerDto.getProviderName());
		provider.setProviderPassword(providerDto.getProviderPassword());
		provider.setProviderEmail(providerDto.getProviderEmail());
		provider.setProviderSpeciality(provider.getProviderSpeciality());
		return healthcareRepo.save(provider);
	}

	@Override
	public List<HealthcareProvider> getAllProviders() {
		return healthcareRepo.findAll();
	}

	@Override
	public HealthcareProvider getProviderById(int providerId) {

		return healthcareRepo.findById(providerId).orElse(null);
	}

	@Override
	public void deleteProviderById(int providerId) {
		healthcareRepo.deleteById(providerId);

	}

}
