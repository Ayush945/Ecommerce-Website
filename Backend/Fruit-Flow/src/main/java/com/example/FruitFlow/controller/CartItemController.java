package com.example.FruitFlow.controller;

import com.example.FruitFlow.dto.CartItemDTO;
import com.example.FruitFlow.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller for Cart Item
 * To add item to cart
 * To delete item from cart
 * */
@RestController
@RequestMapping("cart-item")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @PostMapping("add-to-cart/{customerId}/{itemId}")
    public ResponseEntity<CartItemDTO>addToCart(@PathVariable("customerId") Long customerId,@PathVariable("itemId") Long itemId){
        return ResponseEntity.ok().body(cartItemService.addItemToCart(customerId,itemId));
    }
    @GetMapping("get-cart-item/{customerId}")
    public ResponseEntity<List<CartItemDTO>>getCartItem(@PathVariable("customerId")Long customerId){
        return ResponseEntity.ok().body(cartItemService.getCartItemsByCartId(customerId));
    }
    @DeleteMapping("delete-cart-item/{cartItemId}")
    public ResponseEntity<String>deleteCartItem(@PathVariable("cartItemId")Long cartItemId){
        cartItemService.deleteCartItem(cartItemId);
        return ResponseEntity.ok().body("Item Deleted");
    }
}
