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
 * 0713560770
 *
 * @author Roshan_inova
 */
public class PaymentRequestDto {

    private Integer id;
    private String reciptNo;
    private String reciptIssueToId;
    private String reciptIssueTo;
    private String documentNo;
    private PaymentTypeEnum paymentType;
    private Integer transactionCategory;
    private Integer reference;
    private String description;
    private double amount;
    private IncomeExpenceEnum incomeExpenceType;
    private PaymentMethodEnum paymentMethod;
    private StatusEnum status;
    private Date paymentDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReciptNo() {
        return reciptNo;
    }

    public void setReciptNo(String reciptNo) {
        this.reciptNo = reciptNo;
    }

    public String getReciptIssueToId() {
        return reciptIssueToId;
    }

    public void setReciptIssueToId(String reciptIssueToId) {
        this.reciptIssueToId = reciptIssueToId;
    }

    public String getReciptIssueTo() {
        return reciptIssueTo;
    }

    public void setReciptIssueTo(String reciptIssueTo) {
        this.reciptIssueTo = reciptIssueTo;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentRequestDto{" + "id=" + id + ", reciptNo=" + reciptNo + ", reciptIssueToId=" + reciptIssueToId + ", reciptIssueTo=" + reciptIssueTo + ", documentNo=" + documentNo + ", paymentType=" + paymentType + ", transactionCategory=" + transactionCategory + ", reference=" + reference + ", description=" + description + ", amount=" + amount + ", incomeExpenceType=" + incomeExpenceType + ", paymentMethod=" + paymentMethod + ", status=" + status + '}';
    }

}
