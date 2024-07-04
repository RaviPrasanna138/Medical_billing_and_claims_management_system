package com.wipro.mbcms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.mbcms.entities.InsurancePlans;
@Repository
public interface InsurancePlansRepository extends JpaRepository<InsurancePlans, Integer> {

}
