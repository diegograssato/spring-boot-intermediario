package org.dtux.entity.repository;

import org.springframework.data.repository.CrudRepository;

import org.dtux.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

    public Customer findByName(String name);
}
