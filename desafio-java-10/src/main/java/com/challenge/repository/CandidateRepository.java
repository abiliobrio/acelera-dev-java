package com.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

}
