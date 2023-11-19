package com.example.FruitFlow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private String itemPrice;
    private String itemQuantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")

    private Trader trader;
}
