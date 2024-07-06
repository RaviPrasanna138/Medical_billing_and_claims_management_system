package com.wipro.mbcms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.mbcms.entities.InsurancePlans;
@Repository
public interface InsurancePlansRepository extends JpaRepository<InsurancePlans, Integer> {
//	@Query("SELECT p FROM InsurancePlans p WHERE p.companyName = ?1")
	@Query("select plans from InsurancePlans plans where plans.company.companyName = ?1")
	List<InsurancePlans> findByCompanyName(String companyName);

}
