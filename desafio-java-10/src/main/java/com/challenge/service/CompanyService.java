package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

public class CompanyService implements CompanyServiceInterface{
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company save(Company object) {
		return this.companyRepository.save(object);
	}

	@Override
	public Optional<Company> findById(Long id) {
		return this.companyRepository.findById(id);
	}

	@Override
	public List<Company> findByAccelerationId(Long accelerationId) {
		return this.companyRepository.findDistinctByCandidatesIdAccelerationId(accelerationId);
	}

	@Override
	public List<Company> findByUserId(Long userId) {
		return this.companyRepository.findByCandidatesIdUserId(userId);
	}

}
