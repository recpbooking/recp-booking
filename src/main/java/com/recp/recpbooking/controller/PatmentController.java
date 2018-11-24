/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.common.IncomeExpenceEnum;
import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.PaymentCancelDto;
import com.recp.recpbooking.dto.PaymentRequestDto;
import com.recp.recpbooking.dto.PaymentResponseDto;
import com.recp.recpbooking.dto.PaymentSearchDto;
import com.recp.recpbooking.services.PaymentService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roshan_inova
 */
@RestController
@RequestMapping("${rbs.payment.api.url}")
public class PatmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatmentController.class);

    @Autowired
    PaymentService paymentService;

    @GetMapping("/")
    public ResponseEntity<?>
            getEventListByStatus(@RequestBody PaymentSearchDto paymentSearchDto) {
        LOGGER.info("Payment List fetching Start");
        List<?> paymentDtos = paymentService.getPaymentList(paymentSearchDto);
        LOGGER.info("Payment List successfuly Fetched");
        return ResponseEntity.ok(paymentDtos);
    }

    @GetMapping("/all")
    public ResponseEntity<?>
            getEventList() {
        LOGGER.info("Payment List fetching Start");
        List<?> PaymentDtos = paymentService.getPaymentList();
        LOGGER.info("Payment List successfuly Fetched");
        return ResponseEntity.ok(PaymentDtos);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?>
            getEventByShortCode(@PathVariable(name = "id") String id) {
        LOGGER.info("Payment fetching Start");
        PaymentResponseDto paymentResponseDto = paymentService.getPaymentById(Integer.parseInt(id));
        if (paymentResponseDto != null) {
            LOGGER.info("Payment successfuly Fetched");
            return ResponseEntity.ok(paymentResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Event ID");
        }
    }

    @PostMapping("/addition")
    public ResponseEntity<?> makePaymentAgainstEvent(@RequestBody PaymentRequestDto paymentRequestDto) {
        String user = "";
        try {
            LOGGER.info("Event Creation Start");
            paymentRequestDto.setIncomeExpenceType(IncomeExpenceEnum.INCOME);
            ResponseEntity responseEntity = paymentService.savePayment(paymentRequestDto, user);
            LOGGER.info("Event Created successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Event creation error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.eventSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }

    @PostMapping("/deduction")
    public ResponseEntity<?> makeExpence(@RequestBody PaymentRequestDto paymentRequestDto) {
        String user = "";
        try {
            LOGGER.info("Event Creation Start");
            paymentRequestDto.setIncomeExpenceType(IncomeExpenceEnum.EXPENSE);
            ResponseEntity responseEntity = paymentService.savePayment(paymentRequestDto, user);
            LOGGER.info("Event Created successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Event creation error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.eventSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }

    @PutMapping("/cancel")
    public ResponseEntity<?> cancelPayment(@ModelAttribute PaymentCancelDto cancelDto) {
        String user = "";
        try {
            LOGGER.info("Payment Cancel Start");
            ResponseEntity responseEntity = paymentService.cancelPayment(cancelDto, user);
            LOGGER.info("Payment Cancel successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Payment Cancel error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.paymentCancelationFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }
}
