package com.example.FruitFlow.service.impl;

import com.example.FruitFlow.dto.CartDTO;
import com.example.FruitFlow.dto.CartItemDTO;
import com.example.FruitFlow.entity.Cart;
import com.example.FruitFlow.entity.CartItem;
import com.example.FruitFlow.entity.Item;
import com.example.FruitFlow.repository.CartItemRepository;
import com.example.FruitFlow.repository.CartRepository;
import com.example.FruitFlow.repository.ItemRepository;
import com.example.FruitFlow.service.CartItemService;
import com.example.FruitFlow.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<CartItemDTO> getCartItemsByCartId(Long cartId) {
        List<CartItem>cartItems=cartItemRepository.findByCartCartId(cartId);
        return cartItems.stream()
                .map(cartItem -> modelMapper.map(cartItem,CartItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDTO addItemToCart(Long customerId, Long itemId) {
       Cart cart=cartRepository.findByCustomerCustomerId(customerId)
               .orElseThrow(()->new RuntimeException("Not Found"));
       Item item= itemRepository.findById(itemId)
               .orElseThrow(()->new RuntimeException("Not Found"));
        CartItem cartItem=new CartItem();
        cartItem.setItem(item);
        cartItem.setCart(cart);
        CartItem savedCartItem=cartItemRepository.save(cartItem);
        return modelMapper.map(savedCartItem,CartItemDTO.class);
    }
    @Override
    public void deleteCartItem(Long itemId){
        CartItem cartItem=cartItemRepository.findById(itemId)
                .orElseThrow(()->new RuntimeException("Not Found"));
        cartItemRepository.delete(cartItem);
    }

}
