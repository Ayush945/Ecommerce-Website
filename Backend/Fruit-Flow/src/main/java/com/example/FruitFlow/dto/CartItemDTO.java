package com.example.FruitFlow.dto;

import com.example.FruitFlow.entity.Cart;
import com.example.FruitFlow.entity.Item;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CartItemDTO {
    private Long cartItemId;
    private Integer quantity;
    private CartDTO cart;
    private ItemDTO item;
}
