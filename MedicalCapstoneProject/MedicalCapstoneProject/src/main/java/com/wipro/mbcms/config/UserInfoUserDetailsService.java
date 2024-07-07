package com.wipro.mbcms.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.entities.AdminMedical;
import com.wipro.mbcms.entities.HealthcareProvider;
import com.wipro.mbcms.entities.InsuranceCompany;
import com.wipro.mbcms.entities.Patients;
import com.wipro.mbcms.repositories.AdminMedicalRepository;
import com.wipro.mbcms.repositories.HealthcareProviderRepository;
import com.wipro.mbcms.repositories.InsuranceCompanyRepository;
import com.wipro.mbcms.repositories.PatientRepository;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private HealthcareProviderRepository providerRepo;
	
	@Autowired
	private InsuranceCompanyRepository companyRepo;
	
	@Autowired
	private AdminMedicalRepository adminRepo;

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Patients> patient = patientRepo.findByPatientName(username);
        Optional<HealthcareProvider> provider = providerRepo.findByProviderName(username);
        Optional<InsuranceCompany> company = companyRepo.findByCompanyName(username);
        Optional<AdminMedical> admin = adminRepo.findByAdminName(username);
        
        if(patient.isPresent()) {
        	return patient.map(PatientInfoPatientDetails::new) 
                    .orElseThrow(() -> new UsernameNotFoundException("Patient not found " + username));
        }
        if(provider.isPresent()) {
        	return provider.map(ProviderInfoProviderDetails::new) 
                    .orElseThrow(() -> new UsernameNotFoundException("Provider not found " + username));
        }
        if(company.isPresent()) {
        	return company.map(CompanyInfoCompanyDetails::new) 
                    .orElseThrow(() -> new UsernameNotFoundException("Company not found " + username));
        }
        if(admin.isPresent()) {
        	return admin.map(AdminInfoAdminDetails::new) 
                    .orElseThrow(() -> new UsernameNotFoundException("Admin not found " + username));
        }
        throw new UsernameNotFoundException("Username Not found"+username);

    }
}
