/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.repository;

import com.recp.recpbooking.common.IncomeExpenceEnum;
import com.recp.recpbooking.common.PaymentMethodEnum;
import com.recp.recpbooking.common.PaymentTypeEnum;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.entity.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roshan_inova
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

//    Event findOneByShortCode(String shortCode);

    Iterable<Payment> findByStatus(String status);

    Iterable<Payment> findByPaymentDate(String paymentDate);

    @Query(value = "select * from payment", nativeQuery = true)
    public Iterable<Payment> findAllPayments(String reciptNo, 
            String documentNo, 
            PaymentTypeEnum paymentType, 
            Integer transactionCategory, 
            Integer reference, 
            IncomeExpenceEnum incomeExpenceType, 
            PaymentMethodEnum paymentMethod, 
            String paymentReference, 
            String createdFrom, 
            String createdTo, 
            String updatedFrom, 
            String updatedTo, 
            String createdBy, 
            String updatedBy, 
            StatusEnum status);
}
