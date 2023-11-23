package com.example.FruitFlow.repository;

import com.example.FruitFlow.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    Optional<Item> findByTraderTraderId(Long traderId);
}
