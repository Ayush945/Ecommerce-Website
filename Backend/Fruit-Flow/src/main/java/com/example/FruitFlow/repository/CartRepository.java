package com.example.FruitFlow.repository;

import com.example.FruitFlow.entity.Cart;
import com.example.FruitFlow.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByCustomerCustomerId(Long customerId);
}
