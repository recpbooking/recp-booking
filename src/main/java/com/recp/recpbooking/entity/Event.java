/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.entity;

import com.recp.recpbooking.common.EventTypeEnum;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.common.TimeSlotEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author Roshan_inova
 */
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer", nullable = false, referencedColumnName = "id")
    private Customer customer;
    private EventTypeEnum eventType;
    private Date fromDate;
    private Date toDate;
    private TimeSlotEnum timeSlot;
    private Integer qty;
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "eventPackage", nullable = false, referencedColumnName = "id")
    private EventPackage eventPackage;
    private String description;
    private Double totalAmount;
    private Double totalDiscount;
    private Double totalOtherCharges;
    private Double refundableAmount;
    private Boolean isRefunded = false;
    private Double grandTotal;
    private Double downPayment;
    private Double paidAmount;
    private Double amountPayble;
    private StatusEnum status;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "event")
    private List<EventDetail> eventDetails = new ArrayList<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public EventPackage getEventPackage() {
        return eventPackage;
    }

    public void setEventPackage(EventPackage eventPackage) {
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

    public Boolean getIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(Boolean isRefunded) {
        this.isRefunded = isRefunded;
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

    public List<EventDetail> getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(List<EventDetail> eventDetails) {
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", customer=" + customer.getName() + ", eventType=" + eventType + ", fromDate=" + fromDate + ", toDate=" + toDate + ", timeSlot=" + timeSlot + ", qty=" + qty + ", eventPackage=" + eventPackage.getShortCode() + '}';
    }

}
