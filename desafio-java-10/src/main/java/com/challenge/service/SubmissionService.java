package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service
public class SubmissionService implements SubmissionServiceInterface {
	
	@Autowired
	private SubmissionRepository submissionRepository;

	@Override
	public Submission save(Submission object) {
		return this.submissionRepository.save(object);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		return BigDecimal.valueOf(this.submissionRepository.findHigherScoreByChallengeId(challengeId));
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return this.submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}

}
