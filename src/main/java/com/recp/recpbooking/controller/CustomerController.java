/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.CustomerDto;
import com.recp.recpbooking.services.CustomerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roshan_inova
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("${rbs.customer.api.url}")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<?>
            getCustomerList() {
        LOGGER.info("Customer List fetching Start");
        List<CustomerDto> customerDtos = customerService.getCustomerList();
        LOGGER.info("Customer List successfuly Fetched");
        return ResponseEntity.ok(customerDtos);
    }

    @GetMapping("/byMobileNo")
    public ResponseEntity<?>
            getCustomerListByMobileNo(@RequestParam String mobileNo) {
        LOGGER.info("Customer List By Mobile No fetching Start");
        CustomerDto customerDtos = customerService.getCustomerListByMobileNo(mobileNo);
        LOGGER.info("Customer List By Mobile No successfuly Fetched");
        return ResponseEntity.ok(customerDtos);
    }

    @GetMapping("/byName")
    public ResponseEntity<?>
            getCustomerListByName(@RequestParam String name) {
        LOGGER.info("Customer List By Name fetching Start");
        List<CustomerDto> customerDtos = customerService.getCustomerListByNameLike(name);
        LOGGER.info("Customer List By Name successfuly Fetched");
        return ResponseEntity.ok(customerDtos);
    }

          @PutMapping("/")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto) {
        String user = "";
        try {
            LOGGER.info("Customer Update Start");
            ResponseEntity responseEntity = customerService.updateCustomer(customerDto, user);
            LOGGER.info("Customer Created successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Customer Update error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.itemSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }
       
}
