package com.recp.recpbooking.services;

import com.recp.recpbooking.dto.ItemCategoryDto;
import com.recp.recpbooking.entity.ItemCategory;

import java.util.List;

public interface ItemCategoryService {
    public List<ItemCategoryDto> getItemCategoryList();
}
