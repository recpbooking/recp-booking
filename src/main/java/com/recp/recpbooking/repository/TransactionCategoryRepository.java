/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.repository;

import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.entity.TransactionCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roshan_inova
 */
@Repository
public interface TransactionCategoryRepository extends CrudRepository<TransactionCategory, Integer>{
   
    TransactionCategory findOneByShortCode(String shortCode);

    public Iterable<TransactionCategory> findAllByStatusIn(StatusEnum[] status);
}