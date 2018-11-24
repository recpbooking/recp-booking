package com.recp.recpbooking.services.impl;

import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.ItemCategoryDto;
import com.recp.recpbooking.entity.ItemCategory;
import com.recp.recpbooking.repository.ItemCategoryRepository;
import com.recp.recpbooking.services.ItemCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemCategoryServiceImpl implements ItemCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemCategoryServiceImpl.class);
    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategoryDto> getItemCategoryList() {
        List<ItemCategory> list = null;
        List<ItemCategoryDto> categoryDtos = new ArrayList<>();
        try {
            list = (List<ItemCategory>) itemCategoryRepository.findAll();
            for (ItemCategory itemCategory : list) {
                ItemCategoryDto itemCategoryDto = new ItemCategoryDto();
                BeanUtils.copyProperties(itemCategory, itemCategoryDto);
                categoryDtos.add(itemCategoryDto);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return categoryDtos;
    }

    @Override
    public ItemCategoryDto getItemCategoryByShortCode(String shortCode) {

        LOGGER.info("Start fetching Transaction categories by Short code");
        ItemCategory transactionCategory = itemCategoryRepository.findOneByShortCode(shortCode);
        if (transactionCategory != null) {
            ItemCategoryDto categoryDto = new ItemCategoryDto();
            BeanUtils.copyProperties(transactionCategory, categoryDto);
            return categoryDto;
        }
        return null;
    }

    @Override
    public List<ItemCategoryDto> findAllByStatusIn(StatusEnum[] status) {

        LOGGER.info("Start fetching Transaction categories by Status");
        Iterable<ItemCategory> transactionCategorys = itemCategoryRepository.findAllByStatusIn(status);
        List<ItemCategoryDto> transactionCategoryDtos = new ArrayList();
        for (ItemCategory transactionCategory : transactionCategorys) {
            ItemCategoryDto transactionCategoryDto = new ItemCategoryDto();
            BeanUtils.copyProperties(transactionCategory, transactionCategoryDto);
            transactionCategoryDtos.add(transactionCategoryDto);
        }
        LOGGER.info("Transaction categories fetched");

        return transactionCategoryDtos;
    }

}
