package com.example.FruitFlow.service.impl;

import com.example.FruitFlow.dto.CartDTO;
import com.example.FruitFlow.dto.CartItemDTO;
import com.example.FruitFlow.entity.Cart;
import com.example.FruitFlow.entity.CartItem;
import com.example.FruitFlow.entity.Customer;
import com.example.FruitFlow.repository.CartItemRepository;
import com.example.FruitFlow.repository.CartRepository;
import com.example.FruitFlow.repository.CustomerRepository;
import com.example.FruitFlow.service.CartItemService;
import com.example.FruitFlow.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Override
    public CartDTO createCartForCustomer(Long customerId) {
        Cart cart=new Cart();
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()->new RuntimeException("Customer not found"));
        cart.setCustomer(customer);
        Cart savedCart=cartRepository.save(cart);
        return modelMapper.map(savedCart,CartDTO.class);
    }


    @Override
    public CartDTO getCart(Long customerId) {
        Cart cart=cartRepository.findByCustomerCustomerId(customerId)
                .orElseThrow(()->new RuntimeException("Customer not found"));
        List<CartItemDTO>cartItemDTOS=cartItemService.getCartItemsByCartId(cart.getCartId());
        double totalCartPrice=0.0;
        for (CartItemDTO carItem:cartItemDTOS
             ) {
            if (carItem.getItemDTO().getItemPrice()!=null){
                totalCartPrice=totalCartPrice+carItem.getItemDTO().getItemPrice();
            }
        }
        cart.setTotalPrice(totalCartPrice);
        cartRepository.save(cart);

        return modelMapper.map(cart,CartDTO.class);
    }
}
