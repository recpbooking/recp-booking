///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.recp.recpbooking.entity;
//
//import com.recp.recpbooking.common.StatusEnum;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
///**
// *
// * @author Roshan_inova
// */
//@Entity
//public class ItemGroup implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
//    @JoinColumn(name = "item_group", nullable = false, referencedColumnName = "id")
//    private Item itemGroup;
//
//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "groupItems")
//    private List<Item> groupItems;
//
//    private StatusEnum status;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Item getItemGroup() {
//        return itemGroup;
//    }
//
//    public void setItemGroup(Item itemGroup) {
//        this.itemGroup = itemGroup;
//    }
//
//    public List<Item> getGroupItems() {
//        return groupItems;
//    }
//
//    public void setGroupItems(List<Item> groupItems) {
//        this.groupItems = groupItems;
//    }
//
//    public StatusEnum getStatus() {
//        return status;
//    }
//
//    public void setStatus(StatusEnum status) {
//        this.status = status;
//    }
//
//}
