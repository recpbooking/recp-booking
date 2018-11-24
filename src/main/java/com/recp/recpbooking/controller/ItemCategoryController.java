/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.ItemCategoryDto;
import com.recp.recpbooking.services.ItemCategoryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roshan_inova
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("${rbs.item-category.api.url}")
public class ItemCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemCategoryController.class);

    @Autowired
    ItemCategoryService itemCategoryService;

    @GetMapping("/")
    public ResponseEntity<?>
            getCustomerList() {
        LOGGER.info("Item Category List fetching Start");
        List<ItemCategoryDto> itemCategoryDtos = itemCategoryService.getItemCategoryList();
        LOGGER.info("Item Category List successfuly Fetched");
        return ResponseEntity.ok(itemCategoryDtos);
    }

    @GetMapping("/byStatses")
    public ResponseEntity<?>
            getItemCategoryListByStatuses(@RequestParam StatusEnum[] statuses) {
        LOGGER.info("ItemCategory List By Statuses fetching Start");
        List<ItemCategoryDto> itemCategoryDtos = itemCategoryService.getItemCategoryByStatus(statuses);
        LOGGER.info("ItemCategory List By Statuses successfuly Fetched");
        return ResponseEntity.ok(itemCategoryDtos);
    }

    @GetMapping("/byShortCode")
    public ResponseEntity<?>
            getItemCategoryListByShortCode(@RequestParam String shortCode) {
        LOGGER.info("ItemCategory List By Short Code fetching Start");
        ItemCategoryDto itemCategoryDto = itemCategoryService.getItemCategoryByShortCode(shortCode);
        LOGGER.info("ItemCategory List By Short Code successfuly Fetched");
        return ResponseEntity.ok(itemCategoryDto);
    }
}
