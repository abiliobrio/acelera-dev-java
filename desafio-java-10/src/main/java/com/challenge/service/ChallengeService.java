package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

public class ChallengeService implements ChallengeServiceInterface{
	
	@Autowired
	private ChallengeRepository challengeRepository;

	@Override
	public Challenge save(Challenge object) {
		return this.challengeRepository.save(object);
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		return this.challengeRepository.findAllByAccelerationsIdAndSubmissionsIdUserId(accelerationId, userId);
	}

}
