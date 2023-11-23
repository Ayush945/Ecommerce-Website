package com.example.FruitFlow.dto;

import com.example.FruitFlow.entity.Customer;
import lombok.*;
/**
 * DTO to transfer data.
 * For Cart
 * */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class CartDTO {
    private Long cartId;
    private Double totalPrice;
    private CustomerDTO customer;
}
