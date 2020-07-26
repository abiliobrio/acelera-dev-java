package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query("SELECT COALESCE(max(s.score), 0) FROM Submission s WHERE s.id.challenge.id = ?1")
    Float findHigherScoreByChallengeId(Long challengeId);

    @Query("SELECT s FROM Submission s JOIN Acceleration a ON a.challenge.id = s.id.challenge.id " +
            "WHERE s.id.challenge.id = ?1 AND a.id = ?2")
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
	
}
