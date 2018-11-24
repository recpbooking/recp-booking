/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.entity;

import com.recp.recpbooking.common.StatusEnum;
import java.io.Serializable;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author roshan_inova
 */
@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String shortCode;
    private String name;
    private String description;
    private String imgUrl;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = false, referencedColumnName = "id")
    private ItemCategory category;
    private Double price;
    /*
    If Item Group
     */
    private boolean isGroup;
    private int itemCount;
    private int selectionCount;
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
    private StatusEnum status;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "groupItems",
            joinColumns = {
                @JoinColumn(name = "groupItemId")},
            inverseJoinColumns = {
                @JoinColumn(name = "itemGroupId")})
    private List<Item> groupItems = new ArrayList();

    @ManyToMany(mappedBy = "groupItems")
    private List<Item> itemGroups = new ArrayList();

    @ManyToMany(mappedBy = "packageItems")
    private List<EventPackage> eventPackages = new ArrayList<>();

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

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
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

    public List<Item> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(List<Item> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public List<Item> getGroupItems() {
        return groupItems;
    }

    public void setGroupItems(List<Item> groupItems) {
        this.groupItems = groupItems;
    }

    public List<EventPackage> getEventPackages() {
        return eventPackages;
    }

    public void setEventPackages(List<EventPackage> eventPackages) {
        this.eventPackages = eventPackages;
    }

    @Override
    public String toString() {
        return "Items{" + "id=" + id + ", shortCode=" + shortCode + ", name=" + name + ", description=" + description + ", imgUrl=" + imgUrl + ", type=" + type + ", category=" + category + ", price=" + price + ", isGroup=" + isGroup + ", created=" + created + ", updated=" + updated + ", status=" + status + '}';
    }

}
