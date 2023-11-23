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
    @GetMapping("get-cart-item")
    public ResponseEntity<List<CartItemDTO>>getCartItem(@PathVariable("cartId")Long cartId){
        return ResponseEntity.ok().body(cartItemService.getCartItemsByCartId(cartId));
    }
    @DeleteMapping("delete-cart-item/{itemId}")
    public ResponseEntity<String>deleteCartItem(@PathVariable("itemId")Long itemId){
        cartItemService.deleteCartItem(itemId);
        return ResponseEntity.ok().body("Item Deleted");
    }
}
