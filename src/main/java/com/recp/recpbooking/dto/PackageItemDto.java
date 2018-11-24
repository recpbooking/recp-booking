/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.dto;

import com.recp.recpbooking.common.StatusEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roshan_inova
 */
public class PackageItemDto {

    private String name;
    private String description;
    private String shortCode;
    private Double amount;
    private Double maxDiscount;
    private StatusEnum status;
    private List<Integer> packageItems = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public List<Integer> getPackageItems() {
        return packageItems;
    }

    public void setPackageItems(List<Integer> packageItems) {
        this.packageItems = packageItems;
    }

}
