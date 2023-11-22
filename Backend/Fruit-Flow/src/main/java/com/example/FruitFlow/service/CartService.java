package com.example.FruitFlow.service;

import com.example.FruitFlow.dto.CartDTO;
import com.example.FruitFlow.dto.CartItemDTO;
import com.example.FruitFlow.entity.Cart;

public interface CartService {

    CartDTO createCartForCustomer(Long customerId);



    CartDTO getCart(Long customerId);
}
