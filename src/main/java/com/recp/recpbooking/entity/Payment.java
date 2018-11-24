/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.entity;

import com.recp.recpbooking.common.IncomeExpenceEnum;
import com.recp.recpbooking.common.PaymentMethodEnum;
import com.recp.recpbooking.common.PaymentTypeEnum;
import com.recp.recpbooking.common.StatusEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * 0713560770
 *
 * @author Roshan_inova
 */
@Entity
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reciptNo;
    private String reciptIssueToId;
    private String reciptIssueTo;
    private String documentNo;
    private PaymentTypeEnum paymentType;
    @OneToOne
    private TransactionCategory transactionCategory;
    private Integer reference;
    private String description;
    private double amount;
    private IncomeExpenceEnum incomeExpenceType;
    private PaymentMethodEnum paymentMethod;
    private String paymentReference;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date paymentDate;

    /*
    Audit History
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created", nullable = false)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    private Date updated;
    private String createdBy;
    private String updatedBy;
    private StatusEnum status;

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

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
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

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date date) {
        this.paymentDate = date;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
