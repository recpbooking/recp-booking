/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.dto;

import com.recp.recpbooking.common.IncomeExpenceEnum;
import com.recp.recpbooking.common.PaymentMethodEnum;
import com.recp.recpbooking.common.PaymentTypeEnum;
import com.recp.recpbooking.common.StatusEnum;
import java.util.Date;

/**
 *
 * @author Roshan_inova
 */
public class PaymentSearchDto {

    private String reciptNo;
    private String documentNo;
    private PaymentTypeEnum paymentType;
    private Integer transactionCategory;
    private Integer reference;
    private IncomeExpenceEnum incomeExpenceType;
    private PaymentMethodEnum paymentMethod;
    private String paymentReference;
    private String createdFrom;
    private String createdTo;
    private String updatedFrom;
    private String updatedTo;
    private String createdBy;
    private String updatedByBy;
    private StatusEnum status;

    public String getReciptNo() {
        return reciptNo;
    }

    public void setReciptNo(String reciptNo) {
        this.reciptNo = reciptNo;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public PaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(Integer transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public IncomeExpenceEnum getIncomeExpenceType() {
        return incomeExpenceType;
    }

    public void setIncomeExpenceType(IncomeExpenceEnum incomeExpenceType) {
        this.incomeExpenceType = incomeExpenceType;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getCreatedFrom() {
        return createdFrom;
    }

    public void setCreatedFrom(String createdFrom) {
        this.createdFrom = createdFrom;
    }

    public String getCreatedTo() {
        return createdTo;
    }

    public void setCreatedTo(String createdTo) {
        this.createdTo = createdTo;
    }

    public String getUpdatedFrom() {
        return updatedFrom;
    }

    public void setUpdatedFrom(String updatedFrom) {
        this.updatedFrom = updatedFrom;
    }

    public String getUpdatedTo() {
        return updatedTo;
    }

    public void setUpdatedTo(String updatedTo) {
        this.updatedTo = updatedTo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedByBy() {
        return updatedByBy;
    }

    public void setUpdatedByBy(String updatedByBy) {
        this.updatedByBy = updatedByBy;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentSearchDto{" + "reciptNo=" + reciptNo + ", documentNo=" + documentNo + ", paymentType=" + paymentType + ", transactionCategory=" + transactionCategory + ", reference=" + reference + ", incomeExpenceType=" + incomeExpenceType + ", paymentMethod=" + paymentMethod + ", paymentReference=" + paymentReference + ", createdFrom=" + createdFrom + ", createdTo=" + createdTo + ", updatedFrom=" + updatedFrom + ", updatedTo=" + updatedTo + ", createdBy=" + createdBy + ", updatedByBy=" + updatedByBy + ", status=" + status + '}';
    }

}
