package com.wipro.mbcms.services;

import com.wipro.mbcms.dto.AdminMedicalDTO;
import com.wipro.mbcms.entities.AdminMedical;

public interface IAdminMedicalService {
	public AdminMedical addAdmin(AdminMedicalDTO adminDto);
	
	public AdminMedical updateAdmin(AdminMedicalDTO adminDto);
}
