/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services.impl;

import com.recp.recpbooking.common.IncomeExpenceEnum;
import com.recp.recpbooking.common.PaymentMethodEnum;
import com.recp.recpbooking.common.PaymentTypeEnum;
import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.PaymentCancelDto;
import com.recp.recpbooking.dto.PaymentRequestDto;
import com.recp.recpbooking.dto.PaymentResponseDto;
import com.recp.recpbooking.dto.PaymentSearchDto;
import com.recp.recpbooking.dto.TransactionCategoryDto;
import com.recp.recpbooking.entity.Event;
import com.recp.recpbooking.entity.Payment;
import com.recp.recpbooking.entity.TransactionCategory;
import com.recp.recpbooking.repository.EventRepository;
import com.recp.recpbooking.repository.PaymentRepository;
import com.recp.recpbooking.repository.TransactionCategoryRepository;
import com.recp.recpbooking.services.PaymentService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Roshan_inova
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    @Value("${rbs.payment.conf.event-refund.category}")
    private String eventRefundCategory;

    private Boolean isCancalation = false;

    @Override
    public List<?> getPaymentList() {
        LOGGER.info("Payment List fetching Start");
        Iterable<Payment> payments = paymentRepository.findAll();
        List<PaymentResponseDto> paymentResponseDtos = new ArrayList();
        paymentResponseDtos = getPaymentDtos(payments);
        LOGGER.info("Payment List fetched");
        return paymentResponseDtos;
    }

    @Override
    public List<?> getPaymentList(PaymentSearchDto paymentSearchDto) {
        LOGGER.info("Payment List fetching By search options : " + paymentSearchDto);

        String reciptNo = paymentSearchDto.getReciptNo();
        String documentNo = paymentSearchDto.getDocumentNo();
        PaymentTypeEnum paymentType = paymentSearchDto.getPaymentType();
        Integer transactionCategory = paymentSearchDto.getTransactionCategory();
        Integer reference = paymentSearchDto.getReference();
        IncomeExpenceEnum incomeExpenceType = paymentSearchDto.getIncomeExpenceType();
        PaymentMethodEnum paymentMethod = paymentSearchDto.getPaymentMethod();
        String paymentReference = paymentSearchDto.getPaymentReference();
        String createdFrom = paymentSearchDto.getCreatedFrom();
        String createdTo = paymentSearchDto.getCreatedTo();
        String updatedFrom = paymentSearchDto.getUpdatedFrom();
        String updatedTo = paymentSearchDto.getUpdatedTo();
        String createdBy = paymentSearchDto.getCreatedBy();
        String updatedBy = paymentSearchDto.getUpdatedByBy();
        StatusEnum status = paymentSearchDto.getStatus();

        Iterable<Payment> payments = paymentRepository.findAllPayments(reciptNo,
                documentNo,
                paymentType,
                transactionCategory,
                reference,
                incomeExpenceType,
                paymentMethod,
                paymentReference,
                createdFrom,
                createdTo,
                updatedFrom,
                updatedTo,
                createdBy,
                updatedBy,
                status);
        List<PaymentResponseDto> paymentResponseDtos = new ArrayList();
        paymentResponseDtos = getPaymentDtos(payments);
        LOGGER.info("Payment List By search options fetched");
        return paymentResponseDtos;
    }

    @Override
    public PaymentResponseDto getPaymentById(Integer id) {
        LOGGER.info("Payment List fetching By Date Start");
        Optional<Payment> optional = paymentRepository.findById(id);
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        if (optional.isPresent()) {
            Payment payment = optional.get();
            BeanUtils.copyProperties(payment, paymentResponseDto);
            TransactionCategoryDto categoryDto = new TransactionCategoryDto();
            BeanUtils.copyProperties(payment.getTransactionCategory(), categoryDto);
            paymentResponseDto.setTransactionCategory(categoryDto);
            LOGGER.info("Payment detail fetched : " + paymentResponseDto);
        }
        return paymentResponseDto;
    }

    @Override
    public ResponseEntity savePayment(PaymentRequestDto paymentRequestDto, String user) throws Exception {
        try {
            isCancalation = false;
            BaseResponceDto responceDto = new BaseResponceDto();
            LOGGER.info("Start to save payment : " + paymentRequestDto);
            Payment payment = new Payment();
            BeanUtils.copyProperties(paymentRequestDto, payment);
            Optional<TransactionCategory> category = transactionCategoryRepository.findById(paymentRequestDto.getTransactionCategory());
            if (category.isPresent()) {
                payment.setTransactionCategory(category.get());
                payment.setCreatedBy(user);
                payment.setStatus(StatusEnum.ACTIVE);
                paymentRepository.save(payment);

                //Update Transaction Tables
                updateTransactions(payment, user);

                responceDto.setErrorCode(HttpStatus.CREATED.value());
                responceDto.setErrorMessage(ResponseMessage.paymentSavedSuccess);
                responceDto.setErrorType(StatusEnum.SUCCESS.toString());
                LOGGER.info("Event Saved successful");
                return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
            } else {
                responceDto.setErrorCode(HttpStatus.NOT_FOUND.value());
                responceDto.setErrorMessage(ResponseMessage.paymentSavedFailed);
                responceDto.setErrorType(StatusEnum.INVALID.toString());
                LOGGER.error("Invalid Transaction Category");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responceDto);
            }

        } catch (Exception e) {
            LOGGER.error("Error in Save Payment", e);
            throw e;
        }
    }

    @Override
    public ResponseEntity cancelPayment(PaymentCancelDto paymentCancelDto, String user) throws Exception {
        BaseResponceDto responceDto = new BaseResponceDto();
        try {
            LOGGER.info("Start payment cancelation : " + paymentCancelDto);
            Optional<Payment> optional = paymentRepository.findById(paymentCancelDto.getId());
            if (optional.isPresent()) {
                Payment payment = optional.get();
                payment.setStatus(StatusEnum.CANCELED);
                payment.setUpdatedBy(user);
                paymentRepository.save(payment);
                LOGGER.info("Payment cancelation save to DB");
                isCancalation = true;
                updateTransactions(payment, user);
            }
            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.paymentCanceledSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Payment canceled successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.paymentCancelationFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            LOGGER.error("Payment cancelation error", e);
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);

        }
    }

    private List<PaymentResponseDto> getPaymentDtos(Iterable<Payment> payments) {
        List<PaymentResponseDto> paymentResponseDtos = new ArrayList();
        for (Payment payment : payments) {
            PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
            TransactionCategoryDto category = new TransactionCategoryDto();
            BeanUtils.copyProperties(payment, paymentResponseDto);
            BeanUtils.copyProperties(payment.getTransactionCategory(), category);
            paymentResponseDto.setTransactionCategory(category);
            paymentResponseDtos.add(paymentResponseDto);
            LOGGER.info("Event List fetche : " + paymentResponseDtos);
        }
        return paymentResponseDtos;
    }

    private void updateTransactions(Payment payment, String user) throws Exception {
        LOGGER.info("Start Transaction update");
        Double amount = payment.getAmount();
        amount = isCancalation ? (amount * (-1)) : amount;
        if (payment.getPaymentType().equals(PaymentTypeEnum.EVENT)) {
            LOGGER.info("Evet Payment transaction update started");
//            Integer eventId = Integer.parseInt(paymentRequestDto.getReference());
            Optional<Event> eventO = eventRepository.findById(payment.getReference());
            if (eventO.isPresent()) {
                LOGGER.info("Fetched Payment Evet successfuly");
                Event event = eventO.get();
                if (payment.getIncomeExpenceType().equals(IncomeExpenceEnum.INCOME)) {
                    LOGGER.info("Payment Event Income updateing");
                    event.setUpdatedBy(user);
//                Double dueAount = event.getGrandTotal() - event.getPaidAmount();
//                if(dueAount < paymentRequestDto.getAmount()){}
                    event.setPaidAmount(event.getPaidAmount() + amount);
                    LOGGER.info("Payment Event Income succesfuly updated");
                } else {
                    LOGGER.info("Payment Event Expence identified");
                    if (eventRefundCategory.equalsIgnoreCase(payment.getTransactionCategory().getShoreCode())) {
                        LOGGER.info("Payment Event refund updating");
                        Boolean isRefund = Boolean.TRUE;
                        isRefund = isCancalation ? !isRefund : isRefund;
                        event.setIsRefunded(isRefund);
                    }
                    event.setPaidAmount(event.getPaidAmount() - amount);
                }
                eventRepository.save(event);
                LOGGER.info("Payment Event Expence succesfuly updated");
            } else {
                LOGGER.error("Invalid Transaction referance no. (Eevent ID : " + payment.getReference() + ")");
                throw new Exception("Invalid Transaction referance no. (Eevent ID : " + payment.getReference() + ")");
            }
        }
    }

    private String addOneDay(String toDate) throws ParseException {
        if ("".equalsIgnoreCase(toDate) || null == toDate || toDate.isEmpty()) {
            return "";
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(toDate));
            c.add(Calendar.DATE, 1);  // number of days to add
            toDate = sdf.format(c.getTime());  // dt is now the new date
            return toDate;
        }
    }

}
