/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services;

import com.recp.recpbooking.dto.CreateEventRequestDto;
import com.recp.recpbooking.dto.EventDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Roshan_inova
 */
public interface EventService {

    public List<?> getEventList(String status);

    public List<?> getEventList();

    public List<?> getEventListByDate(String Date);

    public EventDto getEventById(Integer id);

    public ResponseEntity saveEvent(CreateEventRequestDto eventDto, String user) throws Exception;

    public ResponseEntity updateEvent(CreateEventRequestDto eventDto, String user) throws Exception;
}
