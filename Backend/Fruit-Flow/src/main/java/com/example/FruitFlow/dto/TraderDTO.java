package com.example.FruitFlow.dto;

import com.example.FruitFlow.entity.Item;
import com.example.FruitFlow.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO to transfer data.
 * For Trader
 * */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TraderDTO extends UserDTO {
    private Long traderId;
    private final RoleEnum role=RoleEnum.ROLE_TRADER;
    private ItemDTO item;

}
