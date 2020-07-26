package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entity.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long>{
	List<Challenge> findAllByAccelerationsIdAndSubmissionsIdUserId(Long accelerationId, Long submissionId);
}
