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
    private Integer quantity;
    private Double totalPrice;
    private CustomerDTO customerDTO;
}
