package com.example.FruitFlow.service;

import com.example.FruitFlow.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {
    List<CartItemDTO> getCartItemsByCartId(Long cartId);
}
