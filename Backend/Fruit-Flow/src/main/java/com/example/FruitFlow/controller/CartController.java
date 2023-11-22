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
    @PostMapping("create-cart/{customerId}")
    public ResponseEntity<CartDTO>createCartForCustomer(@PathVariable("customerId") Long customerId){
        return ResponseEntity.ok().body(cartService.createCartForCustomer(customerId));
    }
    @GetMapping("get-cart/{customerId}")
    public ResponseEntity<CartDTO>getCart(@PathVariable("customerId") Long customerId){
        return ResponseEntity.ok().body(cartService.getCart(customerId));
    }

}
