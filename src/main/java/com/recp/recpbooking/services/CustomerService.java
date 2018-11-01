/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services;

import com.recp.recpbooking.dto.CustomerDto;
import java.util.List;

/**
 *
 * @author roshan_inova
 */
public interface CustomerService {
    public List<CustomerDto> getCustomerList();
}
