package com.wipro.mbcms.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.HealthcareProviderDTO;
import com.wipro.mbcms.entities.HealthcareProvider;
import com.wipro.mbcms.repositories.HealthcareProviderRepository;
@Service
public class HealthcareProviderServiceImp implements IHealthcareProviderService {

	Logger logger=LoggerFactory.getLogger(HealthcareProviderServiceImp.class);
	
	@Autowired
	private HealthcareProviderRepository healthcareRepo;

	@Override
	public HealthcareProvider addProvider(HealthcareProviderDTO providerDto) {
		HealthcareProvider provider = new HealthcareProvider();
		provider.setProviderName(providerDto.getProviderName());
		provider.setProviderPassword(providerDto.getProviderPassword());
		provider.setProviderEmail(providerDto.getProviderEmail());
		provider.setProviderSpeciality(provider.getProviderSpeciality());
		logger.info("HealthcareProvider is successfully added");
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
		logger.info("HealthcareProvider is updated sucessfully");
		return healthcareRepo.save(provider);
	}

	@Override
	public List<HealthcareProvider> getAllProviders() {
		logger.info("All HealthcareProviders Data is fetched");
		return healthcareRepo.findAll();
	}

	@Override
	public HealthcareProvider getProviderById(int providerId) {
		logger.info("HealthcareProvider with id "+providerId+" is fetched");
		return healthcareRepo.findById(providerId).orElse(null);
	}

	@Override
	public void deleteProviderById(int providerId) {
		logger.warn("HealthcareProvider with id "+providerId+" is deleted");
		healthcareRepo.deleteById(providerId);
	}

}
