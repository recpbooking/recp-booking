/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.dto;

import com.recp.recpbooking.common.StatusEnum;

/**
 *
 * @author Roshan_inova
 */
public class TransactionCategoryDto {

    private Integer id;
    private String shoreCode;
    private String name;
    private String description;
    private StatusEnum status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShoreCode() {
        return shoreCode;
    }

    public void setShoreCode(String shoreCode) {
        this.shoreCode = shoreCode;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

}
