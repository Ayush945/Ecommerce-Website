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

    @PostMapping("add-item")
    public ResponseEntity<ItemDTO>addItem(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.ok().body(itemService.addItem(itemDTO));
    }
    @PutMapping("update-item")
    public ResponseEntity<ItemDTO>updateItem(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.ok().body(itemService.updateItem(itemDTO));
    }
}
