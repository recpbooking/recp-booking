/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services;

import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.TransactionCategoryDto;
import java.util.List;

/**
 *
 * @author Roshan_inova
 */
public interface TransactionCategoryService {

    public List<TransactionCategoryDto> getTransactionCategoryList();

    public TransactionCategoryDto getTransactionCategoryByShortCode(String shortCode);

    List<TransactionCategoryDto> getTransactionCategoryByStatus(StatusEnum[] status);
}
