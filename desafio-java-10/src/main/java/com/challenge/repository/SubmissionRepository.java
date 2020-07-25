package com.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

}
