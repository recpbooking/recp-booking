/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services.impl;

import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.CustomerDto;
import com.recp.recpbooking.entity.Customer;
import com.recp.recpbooking.entity.Item;
import com.recp.recpbooking.entity.ItemCategory;
import com.recp.recpbooking.repository.CustomerRepository;
import com.recp.recpbooking.services.CustomerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author roshan_inova
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getCustomerList() {
        Iterable<Customer> cuustomers = customerRepository.findAllByStatus(StatusEnum.ACTIVE.toString());
        List<CustomerDto> customerDtos = new ArrayList();
        for (Customer customer : cuustomers) {
            CustomerDto itemDto = new CustomerDto();
            BeanUtils.copyProperties(customer, itemDto);
            customerDtos.add(itemDto);
        }

        return customerDtos;
    }

    @Override
    public CustomerDto getCustomerListByMobileNo(String mobileNo) {
        Customer customer = customerRepository.findOneByStatusAndMobileNo(StatusEnum.ACTIVE.toString(), mobileNo);

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        return customerDto;
    }

    @Override
    public List<CustomerDto> getCustomerListByNameLike(String name) {
        Iterable<Customer> customers = customerRepository.findByNameIgnoreCaseLike(name);
        List<CustomerDto> customerDtos = new ArrayList();
        for (Customer customer : customers) {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    @Override
    public ResponseEntity<?> saveCustomer(CustomerDto customerDto, String user) throws Exception {
        Customer customer = new Customer();
        LOGGER.info("Customer Save Init : " + customerDto);
        BaseResponceDto responceDto = new BaseResponceDto();
        try {
            BeanUtils.copyProperties(customerDto, customer);
            customer.setCreatedBy(user);
            customerRepository.save(customer);
            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.itemSavedSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Customer Saved successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Customer Saving Failed", e);
            throw e;
        }
    }

    @Override
    public ResponseEntity<?> updateCustomer(CustomerDto customerDto, String user) {
        try {
            LOGGER.info("Customer Save Init : " + customerDto);
            BaseResponceDto responceDto = new BaseResponceDto();
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerRepository.save(customer);
            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.customerUpdateSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Customer Saved successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Customer Saving Failed", e);
            throw e;
        }
    }

}
