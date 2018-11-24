/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.dto;

import com.recp.recpbooking.entity.*;
import com.recp.recpbooking.common.EventTypeEnum;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.common.TimeSlotEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Roshan_inova
 */
public class CreateEventRequestDto {

    private Long id;
    private Integer customer;
    private EventTypeEnum eventType;
    private Date fromDate;
    private Date toDate;
    private TimeSlotEnum timeSlot;
    private Integer qty;
    private PackageDto eventPackage;
    private String description;
    private Double totalAmount;
    private Double totalDiscount;
    private Double totalOtherCharges;
    private Double refundableAmount;
    private Double grandTotal;
    private Double downPayment;
    private Double paidAmount;
    private Double amountPayble;
    private StatusEnum status;
    private List<CreateEventDetailRequestDto> eventDetails = new ArrayList<>();
    /*
    Audit History
     */
    private Date created;
    private Date updated;
    private String createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public TimeSlotEnum getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlotEnum timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public PackageDto getEventPackage() {
        return eventPackage;
    }

    public void setEventPackage(PackageDto eventPackage) {
        this.eventPackage = eventPackage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getTotalOtherCharges() {
        return totalOtherCharges;
    }

    public void setTotalOtherCharges(Double totalOtherCharges) {
        this.totalOtherCharges = totalOtherCharges;
    }

    public Double getRefundableAmount() {
        return refundableAmount;
    }

    public void setRefundableAmount(Double refundableAmount) {
        this.refundableAmount = refundableAmount;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Double downPayment) {
        this.downPayment = downPayment;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getAmountPayble() {
        return amountPayble;
    }

    public void setAmountPayble(Double amountPayble) {
        this.amountPayble = amountPayble;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<CreateEventDetailRequestDto> getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(List<CreateEventDetailRequestDto> eventDetails) {
        this.eventDetails = eventDetails;
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

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", customer=" + customer + ", eventType=" + eventType + ", fromDate=" + fromDate + ", toDate=" + toDate + ", timeSlot=" + timeSlot + ", qty=" + qty + ", eventPackage=" + eventPackage.getShortCode() + '}';
    }

}
