/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services;

import com.recp.recpbooking.dto.CustomerDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author roshan_inova
 */
public interface CustomerService {

    ResponseEntity<?> saveCustomer(CustomerDto customerDto, String user) throws Exception;

    List<CustomerDto> getCustomerList();

    CustomerDto getCustomerListByMobileNo(String mobileNo);

    List<CustomerDto> getCustomerListByNameLike(String name);

    ResponseEntity<?> updateCustomer(CustomerDto customerDto, String user);
}
