package com.challenge.service;

import java.util.List;
import java.util.Optional;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.service.interfaces.CandidateServiceInterface;

public class CandidateService implements CandidateServiceInterface {

	@Override
	public Candidate save(Candidate object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Candidate> findById(CandidateId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> findByCompanyId(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> findByAccelerationId(Long accelerationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
