package com.example.FruitFlow.entity;

import com.example.FruitFlow.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
}