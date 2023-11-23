package com.example.FruitFlow.entity;

import com.example.FruitFlow.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Entity for Relational Mapping.
 * For Admin
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private final RoleEnum role=RoleEnum.ROLE_ADMIN;
}
