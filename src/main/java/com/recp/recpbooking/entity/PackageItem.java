///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.recp.recpbooking.entity;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
///**
// *
// * @author Roshan_inova
// */
//@Entity
//public class PackageItem implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "eventPackage")
//    private List<Item> packageItems = new ArrayList<>();
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    @Column(name = "created", nullable = false)
//    private Date created;
//    private String createdBy;
//    @Temporal(TemporalType.TIMESTAMP)
//    @UpdateTimestamp
//    @Column(name = "updated", nullable = false)
//    private Date updated;
//    private String updatedBy;
//
//    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
//    @JoinColumn(name = "packageItem", nullable = false, referencedColumnName = "id")
//    private EventPackage eventPackage;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Date getCreated() {
//        return created;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Date getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(Date updated) {
//        this.updated = updated;
//    }
//
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    public EventPackage getEventPackage() {
//        return eventPackage;
//    }
//
//    public void setEventPackage(EventPackage eventPackage) {
//        this.eventPackage = eventPackage;
//    }
//
//    @Override
//    public String toString() {
//        return "PackageItem{" + "id=" + id + ", created=" + created + ", createdBy=" + createdBy + ", updated=" + updated + ", updatedBy=" + updatedBy + ", eventPackage=" + eventPackage + '}';
//    }
//
//}
