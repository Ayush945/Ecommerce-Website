package com.example.FruitFlow.dto;

import com.example.FruitFlow.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerDTO extends UserDTO {
    private Long customerId;
    private final RoleEnum role=RoleEnum.ROLE_CUSTOMER;
}
