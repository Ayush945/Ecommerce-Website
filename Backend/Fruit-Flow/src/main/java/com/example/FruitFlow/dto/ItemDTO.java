package com.example.FruitFlow.dto;

import com.example.FruitFlow.entity.Trader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO to transfer data.
 * For Item
 * */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemDTO {
    private Long itemId;
    private String itemName;
    private Double itemPrice;
    private Integer itemQuantity;

}
