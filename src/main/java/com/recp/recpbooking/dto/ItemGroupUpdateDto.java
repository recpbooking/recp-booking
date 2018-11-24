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
public class ItemGroupUpdateDto {

    private Integer id;
    private String shortCode;
    private String name;
    private String description;
    private String imgUrl;
    private String type;
    private Integer category;
    private Double price;
    private boolean isGroup = true;
    private int itemCount;
    private int selectionCount;
    private StatusEnum status;
    Iterable<Integer> items = new ArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isIsGroup() {
        return isGroup;
    }

    public void setIsGroup(boolean isGroup) {
        this.isGroup = isGroup;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getSelectionCount() {
        return selectionCount;
    }

    public void setSelectionCount(int selectionCount) {
        this.selectionCount = selectionCount;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Iterable<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ItemGroupDto{" + "shortCode=" + shortCode + ", name=" + name + ", description=" + description + ", imgUrl=" + imgUrl + ", type=" + type + ", category=" + category + ", price=" + price + ", isGroup=" + isGroup + ", itemCount=" + itemCount + ", selectionCount=" + selectionCount + ", status=" + status + ", items=" + items + '}';
    }

}
