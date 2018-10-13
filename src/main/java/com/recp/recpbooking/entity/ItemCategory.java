/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author roshan_inova
 */
@Entity
public class ItemCategory implements Serializable {

    @Id
    private Integer id;
    private String shortCord;
    private String name;
    private String description;
    private String status;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "category")
    private List<Items> items = new ArrayList<>();

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Items> getDisheses() {
        return items;
    }

    public void setDisheses(List<Items> disheses) {
        this.items = disheses;
    }

    @Override
    public String toString() {
        return "ItemCategory{" + "id=" + id + ", shortCord=" + shortCord + ", name=" + name + ", description=" + description + ", status=" + status + ", items=" + items + '}';
    }


}
