/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.dto.CustomerDto;
import com.recp.recpbooking.services.CustomerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
            getItemList() {
        LOGGER.info("Item List fetching Start");
        List<CustomerDto> customerDtos = customerService.getCustomerList();
        LOGGER.info("Item List successfuly Fetched");
        return ResponseEntity.ok(customerDtos);
    }
}
