package com.challenge.repository;

import org.springframework.data.repository.CrudRepository;

import com.challenge.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
