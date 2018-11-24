package com.recp.recpbooking.services;

import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.ItemCategoryDto;

import java.util.List;

public interface ItemCategoryService {

    public List<ItemCategoryDto> getItemCategoryList();

    public ItemCategoryDto getItemCategoryByShortCode(String shortCode);

    List<ItemCategoryDto> getItemCategoryByStatus(StatusEnum[] status);
}
