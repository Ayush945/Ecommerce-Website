package com.example.FruitFlow.service.impl;

import com.example.FruitFlow.dto.ItemDTO;
import com.example.FruitFlow.entity.Item;
import com.example.FruitFlow.repository.ItemRepository;
import com.example.FruitFlow.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items=itemRepository.findAll();
        return items.stream()
                .map(item -> modelMapper.map(items,ItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItemById(Long itemId) {
        Item item=itemRepository.findById(itemId)
                .orElseThrow(()->new RuntimeException("Item Not Found"));
        return modelMapper.map(item,ItemDTO.class);
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item=modelMapper.map(itemDTO,Item.class);
        itemRepository.save(item);
        return itemDTO;
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) {
        Item item=modelMapper.map(itemDTO,Item.class);
        Item existingItem=itemRepository.findById(item.getItemId())
                .orElseThrow(()-> new RuntimeException("Item not found"));
        if(item.getItemName()!=null){
            existingItem.setItemName(item.getItemName());
        }
        if(item.getItemPrice()!=null){
            existingItem.setItemPrice(item.getItemPrice());
        }
        if(item.getItemQuantity()!=null){
            existingItem.setItemQuantity(item.getItemQuantity());
        }
        Item updateItem=itemRepository.save(existingItem);
        return modelMapper.map(updateItem,ItemDTO.class);
    }
}
