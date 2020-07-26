package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {
	
	List<Candidate> findByIdCompanyId(Long companyId);
    List<Candidate> findByIdAccelerationId(Long accelerationId);

}
