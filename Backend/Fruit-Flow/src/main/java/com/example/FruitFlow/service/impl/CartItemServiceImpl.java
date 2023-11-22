package com.example.FruitFlow.service.impl;

import com.example.FruitFlow.dto.CartItemDTO;
import com.example.FruitFlow.entity.CartItem;
import com.example.FruitFlow.repository.CartItemRepository;
import com.example.FruitFlow.service.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CartItemDTO> getCartItemsByCartId(Long cartId) {
        List<CartItem>cartItems=cartItemRepository.findByCartCartId(cartId);
        return cartItems.stream()
                .map(cartItem -> modelMapper.map(cartItem,CartItemDTO.class))
                .collect(Collectors.toList());
    }
}
