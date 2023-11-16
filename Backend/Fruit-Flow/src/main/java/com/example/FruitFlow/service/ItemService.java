package com.example.FruitFlow.service;

import com.example.FruitFlow.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getAllItems();

    ItemDTO getItemById(Long itemId);

    ItemDTO addItem(ItemDTO itemDTO);

    ItemDTO updateItem(ItemDTO itemDTO);
}
