package com.example.FruitFlow.controller;

import com.example.FruitFlow.dto.CartDTO;
import com.example.FruitFlow.dto.CartItemDTO;
import com.example.FruitFlow.entity.Cart;
import com.example.FruitFlow.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping("add-to-cart/{customerId}")
    public ResponseEntity<CartItemDTO> addToCart(@PathVariable("customerId") Long customerId,@RequestBody CartItemDTO cartItemDTO){
        return ResponseEntity.ok().body(cartService.addToCart(customerId,cartItemDTO));
    }
}
