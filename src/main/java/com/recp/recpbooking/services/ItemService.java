/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services;

import com.recp.recpbooking.dto.ItemDto;
import com.recp.recpbooking.dto.ItemGroupDto;
import com.recp.recpbooking.dto.ItemGroupUpdateDto;
import com.recp.recpbooking.dto.ItemUpdateDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Roshan_inova
 */
public interface ItemService {

    public ResponseEntity saveItem(ItemDto itemDto, String user);
    
    public ResponseEntity updateItem(ItemUpdateDto itemUpdateDto, String user);
    
    public ResponseEntity saveItemGroup(ItemGroupDto itemGroupDto, String user);
    
    public ResponseEntity updateItemGroup(ItemGroupUpdateDto itemGroupUpdateDto, String user);

    public List<ItemDto> getItemList();

    public List<?> getItemGroupList();

}
