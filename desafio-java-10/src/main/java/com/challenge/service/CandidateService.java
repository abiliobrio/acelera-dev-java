package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.entity.Acceleration;
import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;

public class CandidateService implements CandidateServiceInterface {

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public Candidate save(Candidate object) {
		return this.candidateRepository.save(object);
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		return this.candidateRepository.findById(id);
	}

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		User user = new User();
		user.setId(userId);
		
		Acceleration acceleration = new Acceleration();
		acceleration.setId(accelerationId);
		
		Company company = new Company();
		company.setId(companyId);
		
		CandidateId id = new CandidateId(user, acceleration, company);

		return this.candidateRepository.findById(id);
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		return this.candidateRepository.findByIdCompanyId(companyId);
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		return this.candidateRepository.findByIdAccelerationId(accelerationId);
	}

}
