package com.wipro.mbcms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.mbcms.dto.AdminMedicalDTO;
import com.wipro.mbcms.entities.AdminMedical;
import com.wipro.mbcms.repositories.AdminMedicalRepository;

@Service
public class AdminMedicalServiceImp implements IAdminMedicalService {
	
	@Autowired
	private AdminMedicalRepository adminRepo;

	@Override
	public AdminMedical addAdmin(AdminMedicalDTO adminDto) {
		AdminMedical admin = new AdminMedical();
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminPassword(adminDto.getAdminPassword());
		return adminRepo.save(admin);
	}

	@Override
	public AdminMedical updateAdmin(AdminMedicalDTO adminDto) {
		AdminMedical admin = new AdminMedical();
		admin.setAdminId(adminDto.getAdminId());
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminPassword(adminDto.getAdminPassword());
		return adminRepo.save(admin);
	}

}
