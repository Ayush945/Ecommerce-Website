package com.example.FruitFlow.entity;

import com.example.FruitFlow.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Trader extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long traderId;

    private final RoleEnum role=RoleEnum.ROLE_TRADER;

    @OneToOne(mappedBy = "trader")
    private Item item;
}
