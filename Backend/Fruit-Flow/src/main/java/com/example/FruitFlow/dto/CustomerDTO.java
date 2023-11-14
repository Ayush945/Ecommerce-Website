package com.example.FruitFlow.dto;

import com.example.FruitFlow.enums.RoleEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class CustomerDTO extends UserDTO {
    private Long customerId;
    private final RoleEnum role=RoleEnum.ROLE_CUSTOMER;
}
