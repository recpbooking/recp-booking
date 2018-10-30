/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.*;
import com.recp.recpbooking.entity.ItemCategory;
import com.recp.recpbooking.services.ItemCategoryService;
import com.recp.recpbooking.services.ItemService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Roshan_inova
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("${rbs.item.api.url}")
public class ItemController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCategoryService itemCategoryService;

    
    @GetMapping("/itemList")
    public ResponseEntity<?>
            getItemList() {
        LOGGER.info("Item List fetching Start");
        List<ItemDto> itemDtos = itemService.getItemList();
        LOGGER.info("Item List successfuly Fetched");
        return ResponseEntity.ok(itemDtos);
    }
    
    @GetMapping("/byshortcode/{short_code}")
    public ResponseEntity<?>
            getItemByShortCode(@PathVariable(name = "short_code") String shortCode) {
        LOGGER.info("Item List fetching Start");
        ItemResponseDto itemDto = itemService.getItemByShortCode(shortCode);
        if (itemDto != null) {
            LOGGER.info("Item List successfuly Fetched");
            return ResponseEntity.ok(itemDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Item short code");
        }
    }
    
    @GetMapping("/group")
    public ResponseEntity<?>
            getItemGroupList() {
        LOGGER.info("Item List fetching Start");
        List<?> itemGroupDtos = itemService.getItemGroupList();
        LOGGER.info("Item List successfuly Fetched");
        return ResponseEntity.ok(itemGroupDtos);
    }
    
    @GetMapping("/group/byshortcode/{short_code}")
    public ResponseEntity<?>
            getGroupByShortCode(@PathVariable(name = "short_code") String shortCode) {
        LOGGER.info("Item List fetching Start");
        ItemGroupResponseDto itemDto = itemService.getGroupByShortCode(shortCode);
        if (itemDto != null) {
            LOGGER.info("Item List successfuly Fetched");
            return ResponseEntity.ok(itemDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Item short code");
        }
    }
    
    @PostMapping("/save")
    public ResponseEntity<?> addItem(@RequestBody ItemDto itemDto) {
        String user = "";
        try {
            LOGGER.info("Item Creation Start");
            ResponseEntity responseEntity = itemService.saveItem(itemDto, null, user);
            LOGGER.info("Item Created successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Iten creation error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.itemSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }
    
    @PutMapping("/")
    public ResponseEntity<?> updateItem(@RequestBody ItemUpdateDto itemUpdateDto, @RequestParam("file") MultipartFile uploadFile) {
        String user = "";
        try {
            LOGGER.info("Item Update Start");
            ResponseEntity responseEntity = itemService.updateItem(itemUpdateDto, uploadFile, user);
            LOGGER.info("Item Created successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Iten Update error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.itemSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }
    
    @PostMapping("/group")
    public ResponseEntity<?> addItemGroup(@RequestBody ItemGroupDto itemGroupDto, @RequestParam("file") MultipartFile uploadFile) {
        String user = "";
        try {
            LOGGER.info("Item Group Creation Start");
            ResponseEntity responseEntity = itemService.saveItemGroup(itemGroupDto, uploadFile, user);
            LOGGER.info("Item Group Created successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Iten Group creation error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.itemGroupSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }
    
    @PutMapping("/group")
    public ResponseEntity<?> updateItemGroup(@RequestBody ItemGroupUpdateDto itemGroupUpdateDto, @RequestParam("file") MultipartFile uploadFile) {
        String user = "";
        try {
            LOGGER.info("Item Group Update Start");
            ResponseEntity responseEntity = itemService.updateItemGroup(itemGroupUpdateDto, uploadFile, user);
            LOGGER.info("Item Group Updated successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Iten Group Update error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.itemGroupSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }

    @GetMapping("/itemCategoryList")
    public ResponseEntity<?>
    getItemCategory() {
        List<ItemCategoryDto> itemCategoryList =new ArrayList<>();
        try {
            LOGGER.info("Item List fetching Start");
            itemCategoryList = itemCategoryService.getItemCategoryList();
            LOGGER.info("Item List successfuly Fetched");

        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        return ResponseEntity.ok(itemCategoryList);
    }
}
