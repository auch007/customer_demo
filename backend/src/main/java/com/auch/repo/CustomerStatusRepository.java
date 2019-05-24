package com.auch.repo;

import org.springframework.data.repository.CrudRepository;

import com.auch.entity.CustomerStatus;

public interface CustomerStatusRepository extends CrudRepository<CustomerStatus, String> {
}