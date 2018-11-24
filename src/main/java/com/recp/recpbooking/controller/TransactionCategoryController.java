/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.TransactionCategoryDto;
import com.recp.recpbooking.services.TransactionCategoryService;
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
@RequestMapping("${rbs.tran-category.api.url}")
public class TransactionCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionCategoryController.class);

    @Autowired
    TransactionCategoryService transactionCategoryService;

    @GetMapping("/")
    public ResponseEntity<?>
            getTransactionCategoryList() {
        LOGGER.info("TransactionCategory List fetching Start");
        List<TransactionCategoryDto> customerDtos = transactionCategoryService.getTransactionCategoryList();
        LOGGER.info("TransactionCategory List successfuly Fetched");
        return ResponseEntity.ok(customerDtos);
    }

    @GetMapping("/byStatses")
    public ResponseEntity<?>
            getTransactionCategoryListByStatuses(@RequestParam StatusEnum[] statuses) {
        LOGGER.info("TransactionCategory List By Statuses fetching Start");
        List<TransactionCategoryDto> transactionCategoryDtos = transactionCategoryService.getTransactionCategoryByStatus(statuses);
        LOGGER.info("TransactionCategory List By Statuses successfuly Fetched");
        return ResponseEntity.ok(transactionCategoryDtos);
    }

    @GetMapping("/byShortCode")
    public ResponseEntity<?>
            getTransactionCategoryListByShortCode(@RequestParam String shortCode) {
        LOGGER.info("TransactionCategory List By statuses fetching Start");
        TransactionCategoryDto transactionCategoryDto = transactionCategoryService.getTransactionCategoryByShortCode(shortCode);
        LOGGER.info("TransactionCategory List By statuses successfuly Fetched");
        return ResponseEntity.ok(transactionCategoryDto);
    }

//    @PostMapping("/")
//    public ResponseEntity<?> createTransactionCategory(@RequestBody TransactionCategoryDto transactionCategoryDto) {
//        String user = "";
//        try {
//            LOGGER.info("TransactionCategory Creating Start");
//            ResponseEntity responseEntity = transactionCategoryService.saveTransactionCategory(transactionCategoryDto, user);
//            LOGGER.info("TransactionCategory Created successfuly");
//            return responseEntity;
//        } catch (Exception e) {
//            LOGGER.error("TransactionCategory Update error", e);
//            BaseResponceDto responceDto = new BaseResponceDto();
//            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
//            responceDto.setErrorMessage(ResponseMessage.customerSavedFailed);
//            responceDto.setErrorType(StatusEnum.ERROR.toString());
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
//        }
//    }
//
//    @PutMapping("/")
//    public ResponseEntity<?> updateTransactionCategory(@RequestBody TransactionCategoryDto transactionCategoryDto) {
//        String user = "";
//        try {
//            LOGGER.info("TransactionCategory Update Start");
//            ResponseEntity responseEntity = transactionCategoryService.updateTransactionCategory(transactionCategoryDto, user);
//            LOGGER.info("TransactionCategory Updated successfuly");
//            return responseEntity;
//        } catch (Exception e) {
//            LOGGER.error("TransactionCategory Update error", e);
//            BaseResponceDto responceDto = new BaseResponceDto();
//            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
//            responceDto.setErrorMessage(ResponseMessage.customerUpdatingFailed);
//            responceDto.setErrorType(StatusEnum.ERROR.toString());
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
//        }
//    }
}
