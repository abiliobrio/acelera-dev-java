package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entity.Acceleration;

public interface AccelerationRepository extends JpaRepository<Acceleration,Long>{
	 List<Acceleration> findByCandidatesIdCompanyId(Long id);
}
