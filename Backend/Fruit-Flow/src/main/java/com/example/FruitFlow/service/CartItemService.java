package com.example.FruitFlow.service;

import com.example.FruitFlow.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {
    List<CartItemDTO> getCartItemsByCartId(Long customerId);
    CartItemDTO addItemToCart(Long customerId,Long itemId);
     void deleteCartItem(Long cartItemId);
}
