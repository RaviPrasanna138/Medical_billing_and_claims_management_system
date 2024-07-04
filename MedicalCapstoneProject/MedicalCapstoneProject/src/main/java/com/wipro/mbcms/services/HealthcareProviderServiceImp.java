package com.wipro.mbcms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.mbcms.dto.HealthcareProviderDTO;
import com.wipro.mbcms.entities.HealthcareProvider;
import com.wipro.mbcms.repositories.HealthcareProviderRepository;

public class HealthcareProviderServiceImp implements IHealthcareProviderService {

	@Autowired
	private HealthcareProviderRepository repo;

	@Override
	public HealthcareProvider addProvider(HealthcareProviderDTO providerdto) {
		HealthcareProvider provider = new HealthcareProvider();
		provider.setProviderName(providerdto.getProviderName());
		provider.setProviderPassword(providerdto.getProviderPassword());
		provider.setProviderEmail(providerdto.getProviderEmail());
		provider.setProviderSpeciality(provider.getProviderSpeciality());
		return repo.save(provider);
	}

	@Override
	public HealthcareProvider updateProvider(HealthcareProviderDTO providerdto) {
		HealthcareProvider provider = new HealthcareProvider();
		provider.setProviderId(providerdto.getProviderId());
		provider.setProviderName(providerdto.getProviderName());
		provider.setProviderPassword(providerdto.getProviderPassword());
		provider.setProviderEmail(providerdto.getProviderEmail());
		provider.setProviderSpeciality(provider.getProviderSpeciality());
		return repo.save(provider);
	}

	@Override
	public List<HealthcareProvider> getAllProviders() {
		return repo.findAll();
	}

	@Override
	public HealthcareProvider getProviderById(int providerId) {

		return repo.findById(providerId).orElse(null);
	}

	@Override
	public void deleteProviderById(int providerId) {
		repo.deleteById(providerId);

	}

}
