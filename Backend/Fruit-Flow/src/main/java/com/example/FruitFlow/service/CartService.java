package com.example.FruitFlow.service;

import com.example.FruitFlow.dto.CartItemDTO;

public interface CartService {
    CartItemDTO addToCart(Long customerId, CartItemDTO cartItemDTO);
}
