package com.auch.repo;

import org.springframework.data.repository.CrudRepository;

import com.auch.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}