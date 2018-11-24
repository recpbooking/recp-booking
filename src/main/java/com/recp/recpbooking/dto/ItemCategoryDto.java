package com.recp.recpbooking.dto;

import com.recp.recpbooking.common.StatusEnum;

public class ItemCategoryDto {

    private Integer id;
    private String shortCord;
    private String name;
    private String description;
    private StatusEnum status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortCord() {
        return shortCord;
    }

    public void setShortCord(String shortCord) {
        this.shortCord = shortCord;
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
