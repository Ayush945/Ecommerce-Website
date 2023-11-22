package com.example.FruitFlow.dto;

import com.example.FruitFlow.entity.Cart;
import com.example.FruitFlow.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemDTO {
    private Long cartItemId;
    private Cart cart;
    private Item item;
}
