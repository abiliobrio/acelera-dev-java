package com.challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByAccelerationName(String name);

}
