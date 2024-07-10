package com.wipro.mbcms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.mbcms.dto.InsuranceCompanyDTO;
import com.wipro.mbcms.entities.InsuranceCompany;

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, Integer>{

	Optional<InsuranceCompany> findByCompanyName(String companyName);


}
