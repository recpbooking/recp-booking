package com.recp.recpbooking.services.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.TransactionCategoryDto;
import com.recp.recpbooking.entity.TransactionCategory;
import com.recp.recpbooking.repository.TransactionCategoryRepository;
import com.recp.recpbooking.services.TransactionCategoryService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roshan_inova
 */
@Service
@Transactional
public class TransactionCategoryServiceImpl implements TransactionCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionCategoryServiceImpl.class);

    @Autowired
    TransactionCategoryRepository transactionCategoryRepository;

    @Override
    public List<TransactionCategoryDto> getTransactionCategoryList() {
        LOGGER.info("Start fetching Transaction categories");
        Iterable<TransactionCategory> transactionCategorys = transactionCategoryRepository.findAll();
        LOGGER.info("Transaction categories fetched from DB (Record count : " + transactionCategorys + ")");
        List<TransactionCategoryDto> transactionCategoryDtos = new ArrayList();
        for (TransactionCategory transactionCategory : transactionCategorys) {
            TransactionCategoryDto transactionCategoryDto = new TransactionCategoryDto();
            BeanUtils.copyProperties(transactionCategory, transactionCategoryDto);
            transactionCategoryDtos.add(transactionCategoryDto);
        }
        LOGGER.info("Transaction categories fetched");

        return transactionCategoryDtos;
    }

    @Override
    public TransactionCategoryDto getTransactionCategoryByShortCode(String shortCode) {

        LOGGER.info("Start fetching Transaction categories by Short code");
        TransactionCategory transactionCategory = transactionCategoryRepository.findOneByShortCode(shortCode);
        if (transactionCategory != null) {
            TransactionCategoryDto categoryDto = new TransactionCategoryDto();
            BeanUtils.copyProperties(transactionCategory, categoryDto);
            return categoryDto;
        }
        return null;
    }

    @Override
    public List<TransactionCategoryDto> getTransactionCategoryByStatus(StatusEnum[] status) {

        LOGGER.info("Start fetching Transaction categories by Status");
        Iterable<TransactionCategory> transactionCategorys = transactionCategoryRepository.findAllByStatusIn(status);
        List<TransactionCategoryDto> transactionCategoryDtos = new ArrayList();
        for (TransactionCategory transactionCategory : transactionCategorys) {
            TransactionCategoryDto transactionCategoryDto = new TransactionCategoryDto();
            BeanUtils.copyProperties(transactionCategory, transactionCategoryDto);
            transactionCategoryDtos.add(transactionCategoryDto);
        }
        LOGGER.info("Transaction categories fetched");

        return transactionCategoryDtos;
    }

}
