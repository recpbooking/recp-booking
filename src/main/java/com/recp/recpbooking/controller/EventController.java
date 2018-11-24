/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.CreateEventRequestDto;
import com.recp.recpbooking.dto.EventDto;
;
import com.recp.recpbooking.services.EventService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roshan_inova
 */


@RestController
@RequestMapping("${rbs.event.api.url}")
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventService eventService;

    @GetMapping("/{status}")
    public ResponseEntity<?>
            getEventListByStatus(@PathVariable String status) {
        LOGGER.info("Event List fetching Start");
        List<?> eventEventDtos = eventService.getEventList(status);
        LOGGER.info("Event List successfuly Fetched");
        return ResponseEntity.ok(eventEventDtos);
    }

    @GetMapping("/")
    public ResponseEntity<?>
            getEventList() {
        LOGGER.info("Event List fetching Start");
        List<?> eventEventDtos = eventService.getEventList();
        LOGGER.info("Event List successfuly Fetched");
        return ResponseEntity.ok(eventEventDtos);
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?>
            getEventByShortCode(@PathVariable(name = "id") String id) {
        LOGGER.info("Event fetching Start");
        EventDto packageResponseDto = eventService.getEventById(Integer.parseInt(id));
        if (packageResponseDto != null) {
            LOGGER.info("Event successfuly Fetched");
            return ResponseEntity.ok(packageResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Event ID");
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> addEvent(@ModelAttribute CreateEventRequestDto eventItemDto) {
        String user = "";
        try {
            LOGGER.info("Event Creation Start");
            ResponseEntity responseEntity = eventService.saveEvent(eventItemDto, user);
            LOGGER.info("Event Created successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Event creation error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.eventSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateEvent(@ModelAttribute CreateEventRequestDto eventDto) {
        String user = "";
        try {
            LOGGER.info("Event Updated Start");
            ResponseEntity responseEntity = eventService.updateEvent(eventDto, user);
            LOGGER.info("Event Updated successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Event Updating error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.eventUpdatingFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }
}
