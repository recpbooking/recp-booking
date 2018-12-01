/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.repository;

import com.recp.recpbooking.entity.EventDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roshan_inova
 */
@Repository
public interface EventRepository extends CrudRepository<EventDetail, Integer> {

    Iterable<Event> findByStatus(String status);

    @Query(value = "", nativeQuery = true)
    Iterable<Event> getEvenByFromDate(String fromDate);
}
