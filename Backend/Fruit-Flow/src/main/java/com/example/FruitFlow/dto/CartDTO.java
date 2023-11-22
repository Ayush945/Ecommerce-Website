package com.example.FruitFlow.dto;

import com.example.FruitFlow.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartDTO {
    private Long cartId;
    private String quantity;
    private String totalPrice;
    private Customer customer;
}
