/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roshan_inova
 */
public class PackageResponseDto {

    private Integer id;
    private String name;
    private String description;
    private String shortCode;
    private Double amount;
    private Double maxDiscount;
    private String status;
    private List<ItemGroupResponseDto> packageItems = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemGroupResponseDto> getPackageItems() {
        return packageItems;
    }

    public void setPackageItems(List<ItemGroupResponseDto> packageItems) {
        this.packageItems = packageItems;
    }

    @Override
    public String toString() {
        return "PackageResponseDto{" + "id=" + id + ", name=" + name + ", description=" + description + ", shortCode=" + shortCode + ", amount=" + amount + ", maxDiscount=" + maxDiscount + ", status=" + status + ", packageItems=" + packageItems + '}';
    }

}
