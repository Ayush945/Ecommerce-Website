package com.example.FruitFlow.controller;

import com.example.FruitFlow.dto.ItemDTO;
import com.example.FruitFlow.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("update-item")
    public ResponseEntity<ItemDTO>updateItem(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.ok().body(itemService.updateItem(itemDTO));
    }
}
