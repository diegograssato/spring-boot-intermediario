package org.dtux.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.dtux.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}