package com.example.FruitFlow.repository;

import com.example.FruitFlow.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository< Customer,Long> {
    Optional<Customer> findByUsername(String username);
}
