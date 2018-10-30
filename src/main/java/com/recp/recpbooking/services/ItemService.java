/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services;

import com.recp.recpbooking.dto.ItemDto;
import com.recp.recpbooking.dto.ItemGroupDto;
import com.recp.recpbooking.dto.ItemGroupResponseDto;
import com.recp.recpbooking.dto.ItemGroupUpdateDto;
import com.recp.recpbooking.dto.ItemResponseDto;
import com.recp.recpbooking.dto.ItemUpdateDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Roshan_inova
 */
public interface ItemService {

    public ResponseEntity saveItem(ItemDto itemDto, MultipartFile uploadFile, String user) throws Exception;
    
    public ResponseEntity updateItem(ItemUpdateDto itemUpdateDto, MultipartFile uploadFile, String user) throws Exception;
    
    public ResponseEntity saveItemGroup(ItemGroupDto itemGroupDto, MultipartFile uploadFile, String user) throws Exception;
    
    public ResponseEntity updateItemGroup(ItemGroupUpdateDto itemGroupUpdateDto, MultipartFile uploadFile, String user) throws Exception;

    public List<ItemDto> getItemList();

    public List<?> getItemGroupList();

    public ItemResponseDto getItemByShortCode(String shortCode);

    public ItemGroupResponseDto getGroupByShortCode(String shortCode);


}
