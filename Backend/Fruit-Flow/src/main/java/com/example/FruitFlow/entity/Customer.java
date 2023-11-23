package com.example.FruitFlow.entity;

import com.example.FruitFlow.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/**
 * Entity for Relational Mapping.
 * For Customer
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private final RoleEnum role=RoleEnum.ROLE_CUSTOMER;
//
//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    private Cart cart;
}
