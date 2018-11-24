/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.dto;

import com.recp.recpbooking.common.StatusEnum;
import java.util.Date;

/**
 *
 * @author Roshan_inova
 */
public class EventDetailDto {

    private Long id;
    private ItemGroupResponseDto item;
    private boolean isPackage;
    private boolean isGroup;
    private String description;
    private Integer qty;
    private double unitPrice;
    private double discount;
    private double netAmount;
    private EventDto event;
    /*
    Audit History
     */
    private Date created;
    private Date updated;
    private StatusEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemGroupResponseDto getItem() {
        return item;
    }

    public void setItem(ItemGroupResponseDto item) {
        this.item = item;
    }

    public boolean isIsPackage() {
        return isPackage;
    }

    public void setIsPackage(boolean isPackage) {
        this.isPackage = isPackage;
    }

    public boolean isIsGroup() {
        return isGroup;
    }

    public void setIsGroup(boolean isGroup) {
        this.isGroup = isGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public EventDto getEvent() {
        return event;
    }

    public void setEvent(EventDto event) {
        this.event = event;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EventDetail{" + "id=" + id + ", item=" + item + ", isPackage=" + isPackage + ", isGroup=" + isGroup + ", description=" + description + ", qty=" + qty + ", unitPrice=" + unitPrice + ", discount=" + discount + ", netAmount=" + netAmount + ", event=" + event + ", status=" + status + '}';
    }

}
