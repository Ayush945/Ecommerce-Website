package com.example.FruitFlow.service.impl;

import com.example.FruitFlow.dto.ItemDTO;
import com.example.FruitFlow.entity.Item;
import com.example.FruitFlow.entity.Trader;
import com.example.FruitFlow.repository.ItemRepository;
import com.example.FruitFlow.repository.TraderRepository;
import com.example.FruitFlow.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TraderRepository traderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items=itemRepository.findAll();

        return items.stream()
                .map(item -> modelMapper.map(item,ItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItemById(Long itemId) {
        Item item=itemRepository.findById(itemId)
                .orElseThrow(()->new RuntimeException("Item Not Found"));
        return modelMapper.map(item,ItemDTO.class);
    }

    @Override
    public ItemDTO addItem(Long traderId,ItemDTO itemDTO) {
        Trader trader=traderRepository.findById(traderId)
                .orElseThrow(()->new RuntimeException("Trader not found"));

        Item item=modelMapper.map(itemDTO,Item.class);
        item.setTrader(trader);
        itemRepository.save(item);
        return modelMapper.map(item,ItemDTO.class);
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

    @Override
    public ItemDTO getTraderItemById(Long traderId) {
        Trader trader=traderRepository.findById(traderId)
                .orElseThrow(()->new RuntimeException("Trader not found"));
        Item item=trader.getItem();
        return modelMapper.map(item,ItemDTO.class);
    }
}
