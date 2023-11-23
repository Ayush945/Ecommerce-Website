package com.example.FruitFlow.controller;

import com.example.FruitFlow.dto.ItemDTO;
import com.example.FruitFlow.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller for item
 * To get all items
 * To get Items by Trader
 * To add items by Trader
 * To delete item by Trader
 * */
@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("get-all-items")
    public ResponseEntity<List<ItemDTO>>getAllItems(){
        return ResponseEntity.ok().body(itemService.getAllItems());
    }
    @GetMapping("get-item/{itemId}")
    public ResponseEntity<ItemDTO>getItemById(@PathVariable("itemId") Long itemId){
        return ResponseEntity.ok().body(itemService.getItemById(itemId));
    }

    @GetMapping("get-trader-item/{traderId}")
    public ResponseEntity<ItemDTO>getTraderItemById(@PathVariable("traderId") Long traderId){
        return ResponseEntity.ok().body(itemService.getTraderItemById(traderId));
    }
    @PostMapping("add-item/{traderId}")
    public ResponseEntity<ItemDTO>addItem(@PathVariable ("traderId") Long traderId, @RequestBody ItemDTO itemDTO){
        return ResponseEntity.ok().body(itemService.addItem(traderId,itemDTO));
    }
    @PutMapping("update-item/{traderId}")
    public ResponseEntity<ItemDTO>updateItem(@PathVariable("traderId") Long traderId,@RequestBody ItemDTO itemDTO){
        return ResponseEntity.ok().body(itemService.updateItem(traderId,itemDTO));
    }
}
