package com.example.FruitFlow.repository;

import com.example.FruitFlow.entity.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraderRepository extends JpaRepository<Trader,Long> {

    Optional<Trader> findByUsername(String username);
}
