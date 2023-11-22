package com.example.FruitFlow.repository;

import com.example.FruitFlow.dto.CartItemDTO;
import com.example.FruitFlow.entity.Cart;
import com.example.FruitFlow.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findByCartCartId(Long cartId);

    Optional<CartItem> findByItemItemId(Long itemId);
}
