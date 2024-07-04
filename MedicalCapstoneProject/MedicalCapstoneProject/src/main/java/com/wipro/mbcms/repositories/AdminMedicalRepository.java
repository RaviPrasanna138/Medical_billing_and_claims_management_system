package com.wipro.mbcms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.mbcms.entities.AdminMedical;

@Repository
public interface AdminMedicalRepository extends JpaRepository<AdminMedical, Integer>{

}
