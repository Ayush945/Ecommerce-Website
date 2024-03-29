package com.example.FruitFlow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
/**
 * Entity for Relational Mapping.
 * For Item
 * */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private Double itemPrice;
    private Integer itemQuantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trader_id")

    private Trader trader;


}
