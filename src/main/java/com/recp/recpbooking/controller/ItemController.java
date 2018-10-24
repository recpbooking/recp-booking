/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.ItemDto;
import com.recp.recpbooking.dto.ItemGroupDto;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<?>
            getItemList() {
        LOGGER.info("Item List fetching Start");
        List<ItemDto> itemDtos = itemService.getItemList();
        LOGGER.info("Item List successfuly Fetched");
        return ResponseEntity.ok(itemDtos);
    }

    @GetMapping("/group")
    public ResponseEntity<?>
            getItemGroupList() {
        LOGGER.info("Item List fetching Start");
        List<?> itemGroupDtos = itemService.getItemGroupList();
        LOGGER.info("Item List successfuly Fetched");
        return ResponseEntity.ok(itemGroupDtos);
    }

    @PostMapping("/")
    public ResponseEntity<?> addItem(@RequestBody ItemDto itemDto) {
        String user = "";
        try {
            LOGGER.info("Item Creation Start");
            ResponseEntity responseEntity = itemService.saveItem(itemDto, user);
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

    @PostMapping("/group")
    public ResponseEntity<?> addItemGroup(@RequestBody ItemGroupDto itemGroupDto) {
        String user = "";
        try {
            LOGGER.info("Item Group Creation Start");
            ResponseEntity responseEntity = itemService.saveItemGroup(itemGroupDto, user);
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
}
