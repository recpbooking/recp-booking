/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services.impl;

import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.CreateEventDetailRequestDto;
import com.recp.recpbooking.dto.CreateEventRequestDto;
import com.recp.recpbooking.dto.EventDetailDto;
import com.recp.recpbooking.dto.EventDto;
import com.recp.recpbooking.dto.ItemGroupResponseDto;
import com.recp.recpbooking.dto.ItemResponseDto;
import com.recp.recpbooking.entity.Event;
import com.recp.recpbooking.entity.EventDetail;
import com.recp.recpbooking.entity.Item;
import com.recp.recpbooking.repository.EventRepository;
import com.recp.recpbooking.repository.ItemRepository;
import com.recp.recpbooking.services.EventService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Roshan_inova
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<?> getEventList() {
        LOGGER.info("Event List fetching Start");
        Iterable<Event> events = eventRepository.findAll();
        List<EventDto> eventDtos = new ArrayList();
        eventDtos = getEventDtos(events);
        LOGGER.info("Event List fetched");
        return eventDtos;
    }

    @Override
    public List<?> getEventList(String status) {
        LOGGER.info("Event List fetching By Status Start");
        Iterable<Event> events = eventRepository.findByStatus(status);
        List<EventDto> eventDtos = new ArrayList();
        eventDtos = getEventDtos(events);
        LOGGER.info("Event List By Status fetched");
        return eventDtos;
    }

    @Override
    public List<?> getEventListByDate(String date) {
        LOGGER.info("Event List fetching By Date Start");
       
        Iterable<Event> events = eventRepository.getEvenByFromDate(date);
        List<EventDto> eventDtos = new ArrayList();
        eventDtos = getEventDtos(events);
        LOGGER.info("Event List By Date fetched");
        return eventDtos;
    }

    @Override
    public EventDto getEventById(Integer id) {
        LOGGER.info("Event List fetching By Date Start");
        Optional<Event> eventO = eventRepository.findById(id);
        EventDto eventDto = new EventDto();
        if (eventO.isPresent()) {
            Event event = eventO.get();
//            List<EventDetailDto> eventDetailDtos = new ArrayList();
            for (EventDetail eventDetail : event.getEventDetails()) {
                EventDetailDto eventDetailDto = new EventDetailDto();
                ItemGroupResponseDto itemGroupResponseDto = new ItemGroupResponseDto();
                BeanUtils.copyProperties(eventDetail.getItem(), itemGroupResponseDto);
                if (eventDetail.isIsGroup()) {
                    for (Item groupItem : eventDetail.getItem().getGroupItems()) {
                        ItemResponseDto itemResponseDto = new ItemResponseDto();
                        BeanUtils.copyProperties(groupItem, itemResponseDto);
                        itemGroupResponseDto.getItems().add(itemResponseDto);
                    }
                }
                BeanUtils.copyProperties(eventDetail, eventDetailDto);
                eventDetailDto.setItem(itemGroupResponseDto);
                eventDto.getEventDetails().add(eventDetailDto);
            }
            BeanUtils.copyProperties(event, eventDto);
            LOGGER.info("Event List fetche : " + eventDto);
        }
        return eventDto;
    }

    @Override
    public ResponseEntity saveEvent(CreateEventRequestDto eventDto, String user) throws Exception {
        try {
            BaseResponceDto responceDto = new BaseResponceDto();
            LOGGER.info("Start to save Event : " + eventDto);
            Event event = new Event();
            for (CreateEventDetailRequestDto eventDetailDto : eventDto.getEventDetails()) {
                EventDetail eventDetail = new EventDetail();
                BeanUtils.copyProperties(eventDetailDto, eventDetail);
                Item item = new Item();
                Optional<Item> optional = itemRepository.findById(eventDetailDto.getItem());
                if (optional.isPresent()) {
                    item = optional.get();
                    eventDetail.setItem(item);
                } else {
                    LOGGER.error("Item Not Found : " + eventDetailDto.getId());
                    throw new Exception("Item Not Found");
                }
                event.getEventDetails().add(eventDetail);
            }
            BeanUtils.copyProperties(eventDto, event);
            event.setCreatedBy(user);
            eventRepository.save(event);

            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.packageSavedSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Event Saved successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Error in Save Event", e);
            throw e;
        }
    }

    @Override
    public ResponseEntity updateEvent(CreateEventRequestDto eventDto, String user) throws Exception {
        try {
            BaseResponceDto responceDto = new BaseResponceDto();
            LOGGER.info("Start to Update Event : " + eventDto);
            Event event = new Event();
            for (CreateEventDetailRequestDto eventDetailDto : eventDto.getEventDetails()) {
                EventDetail eventDetail = new EventDetail();
                BeanUtils.copyProperties(eventDetailDto, eventDetail);
                Item item = new Item();
                Optional<Item> optional = itemRepository.findById(eventDetailDto.getItem());
                if (optional.isPresent()) {
                    item = optional.get();
                    eventDetail.setItem(item);
                } else {
                    LOGGER.error("Item Not Found : " + eventDetailDto.getId());
                    throw new Exception("Item Not Found");
                }
                event.getEventDetails().add(eventDetail);
            }
            BeanUtils.copyProperties(eventDto, event);
            event.setUpdatedBy(user);
            eventRepository.save(event);

            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.packageSavedSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Event Update successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Error in Update Event", e);
            throw e;
        }
    }

    private List<EventDto> getEventDtos(Iterable<Event> events) {
        List<EventDto> eventDtos = new ArrayList();
        for (Event event : events) {
            EventDto eventDto = new EventDto();
//            List<EventDetailDto> eventDetailDtos = new ArrayList();
            for (EventDetail eventDetail : event.getEventDetails()) {
                EventDetailDto eventDetailDto = new EventDetailDto();
                ItemGroupResponseDto itemGroupResponseDto = new ItemGroupResponseDto();
                BeanUtils.copyProperties(eventDetail.getItem(), itemGroupResponseDto);
                if (eventDetail.isIsGroup()) {
                    for (Item groupItem : eventDetail.getItem().getGroupItems()) {
                        ItemResponseDto itemResponseDto = new ItemResponseDto();
                        BeanUtils.copyProperties(groupItem, itemResponseDto);
                        itemGroupResponseDto.getItems().add(itemResponseDto);
                    }
                }
                BeanUtils.copyProperties(eventDetail, eventDetailDto);

                eventDetailDto.setItem(itemGroupResponseDto);
                eventDto.getEventDetails().add(eventDetailDto);
            }

            BeanUtils.copyProperties(event, eventDto);
            eventDtos.add(eventDto);
            LOGGER.info("Event List fetche : " + eventDtos);
        }
        return eventDtos;
    }

}
