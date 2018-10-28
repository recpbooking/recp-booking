package com.recp.recpbooking.services.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.ItemDto;
import com.recp.recpbooking.dto.ItemGroupDto;
import com.recp.recpbooking.dto.ItemGroupResponseDto;
import com.recp.recpbooking.dto.ItemGroupUpdateDto;
import com.recp.recpbooking.dto.ItemUpdateDto;
import com.recp.recpbooking.entity.Item;
import com.recp.recpbooking.entity.ItemCategory;
import com.recp.recpbooking.repository.ItemCategoryRepository;
import com.recp.recpbooking.repository.ItemRepository;
import com.recp.recpbooking.services.ItemService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roshan_inova
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Override
    public ResponseEntity saveItem(ItemDto insertItemRequestDto, String user) {
        Item item = new Item();
        LOGGER.info("Item Save Init : " + insertItemRequestDto);
        BaseResponceDto responceDto = new BaseResponceDto();
        try {
            BeanUtils.copyProperties(insertItemRequestDto, item);
            Optional<ItemCategory> itemCategorys = itemCategoryRepository.findById(insertItemRequestDto.getCategory());
            item.setCategory(itemCategorys.get());
            itemRepository.save(item);
            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.itemSavedSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Item Saved successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Item Saving Failed", e);
            throw e;
        }
    }
    
    @Override
    public ResponseEntity updateItem(ItemUpdateDto itemUpdateDto, String user) {
        Item item = new Item();
        LOGGER.info("Item update Init : " + itemUpdateDto);
        BaseResponceDto responceDto = new BaseResponceDto();
        try {
            BeanUtils.copyProperties(itemUpdateDto, item);
            Optional<ItemCategory> itemCategorys = itemCategoryRepository.findById(itemUpdateDto.getCategory());
            item.setCategory(itemCategorys.get());
            itemRepository.save(item);
            responceDto.setErrorCode(HttpStatus.OK.value());
            responceDto.setErrorMessage(ResponseMessage.itemSavedSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Item successfully updated");
            return ResponseEntity.status(HttpStatus.OK).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Item Failed to update", e);
            throw e;
        }
    }

    @Override
    public ResponseEntity saveItemGroup(ItemGroupDto itemGroupDto, String user) {
        Item item = new Item();
        LOGGER.info("Item Save Init : " + itemGroupDto);
        BaseResponceDto responceDto = new BaseResponceDto();
        try {
            BeanUtils.copyProperties(itemGroupDto, item);
            Optional<ItemCategory> itemCategorys = itemCategoryRepository.findById(itemGroupDto.getCategory());
            item.setCategory(itemCategorys.get());
            Iterable<Item> items = itemRepository.findAllById(itemGroupDto.getItems());

            for (Item item1 : items) {
                item1.getItemGroups().add(item);
            }
            item.getGroupItems().addAll((Collection<? extends Item>) items);
            itemRepository.save(item);
            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.itemSavedSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Item Group Saved successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Item Group Saving Failed", e);
            throw e;
        }
    }

    @Override
    public ResponseEntity updateItemGroup(ItemGroupUpdateDto itemGroupUpdateDto, String user) {
        Item item = new Item();
        LOGGER.info("Item Group Save Init : " + itemGroupUpdateDto);
        BaseResponceDto responceDto = new BaseResponceDto();
        try {
            BeanUtils.copyProperties(itemGroupUpdateDto, item);
            Optional<ItemCategory> itemCategorys = itemCategoryRepository.findById(itemGroupUpdateDto.getCategory());
            item.setCategory(itemCategorys.get());
            Iterable<Item> items = itemRepository.findAllById(itemGroupUpdateDto.getItems());

            for (Item item1 : items) {
                item1.getItemGroups().add(item);
            }
            item.getGroupItems().addAll((Collection<? extends Item>) items);
            itemRepository.save(item);
            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.itemSavedSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Item Group Saved successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Item Group Saving Failed", e);
            throw e;
        }
    }

    @Override
    public List<ItemDto> getItemList() {
        Iterable<Item> items = itemRepository.findAllByIsGroup(false);
        List<ItemDto> itemDtos = new ArrayList();
        for (Item item : items) {
            ItemDto itemDto = new ItemDto();
            BeanUtils.copyProperties(item, itemDto);
            itemDtos.add(itemDto);
        }

        return itemDtos;
    }

    @Override
    public List<ItemGroupResponseDto> getItemGroupList() {
        Iterable<Item> items = itemRepository.findAllByIsGroup(true);
        List<ItemGroupResponseDto> itemGroupDtos = new ArrayList();
        for (Item item : items) {
            ItemGroupResponseDto itemGroupDto = new ItemGroupResponseDto();
            BeanUtils.copyProperties(item, itemGroupDto);
            for (Item groupItem : item.getGroupItems()) {
                ItemDto dto = new ItemDto();
                BeanUtils.copyProperties(groupItem, dto);
                itemGroupDto.getItems().add(dto);

            }
            itemGroupDtos.add(itemGroupDto);
        }

        return itemGroupDtos;
    }

}
