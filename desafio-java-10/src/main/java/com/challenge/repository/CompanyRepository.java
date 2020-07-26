package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);

	List<Company> findByCandidatesIdUserId(Long userId);
}
