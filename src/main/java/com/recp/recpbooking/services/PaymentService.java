/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services;

import com.recp.recpbooking.dto.PaymentCancelDto;
import com.recp.recpbooking.dto.PaymentRequestDto;
import com.recp.recpbooking.dto.PaymentResponseDto;
import com.recp.recpbooking.dto.PaymentSearchDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Roshan_inova
 */
public interface PaymentService {

    public List<?> getPaymentList(PaymentSearchDto paymentSearchDto);

    public List<?> getPaymentList();

    public PaymentResponseDto getPaymentById(Integer id);

    public ResponseEntity cancelPayment(PaymentCancelDto paymentCancelDto, String user) throws Exception;

    public ResponseEntity savePayment(PaymentRequestDto paymentRequestDto, String user) throws Exception;
}
