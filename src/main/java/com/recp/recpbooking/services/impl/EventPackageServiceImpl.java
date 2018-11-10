/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services.impl;

import com.google.common.collect.Lists;
import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.ItemGroupResponseDto;
import com.recp.recpbooking.dto.ItemResponseDto;
import com.recp.recpbooking.dto.PackageDto;
import com.recp.recpbooking.dto.PackageItemDto;
import com.recp.recpbooking.dto.PackageResponseDto;
import com.recp.recpbooking.entity.EventPackage;
import com.recp.recpbooking.entity.Item;
import com.recp.recpbooking.repository.EventPackageRepository;
import com.recp.recpbooking.repository.ItemRepository;
import com.recp.recpbooking.services.EventPackageService;
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

/**
 *
 * @author Roshan_inova
 */
@Service
public class EventPackageServiceImpl implements EventPackageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventPackageServiceImpl.class);

    @Autowired
    EventPackageRepository eventPackageRepository;

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<?> getEventPackageList() {
        LOGGER.info("Package List fetching Start");
        Iterable<EventPackage> eventPackages = eventPackageRepository.findAll();
        List<PackageDto> packageDtos = new ArrayList();
        for (EventPackage eventPackage : eventPackages) {
            PackageDto packageDto = new PackageDto();
            for (Item packageItem : eventPackage.getPackageItems()) {
                ItemGroupResponseDto groupResponseDto = new ItemGroupResponseDto();
                for (Item groupItem : packageItem.getGroupItems()) {
                    ItemResponseDto itemResponseDto = new ItemResponseDto();
                    BeanUtils.copyProperties(groupItem, itemResponseDto);
                    groupResponseDto.getItems().add(itemResponseDto);
                }
                BeanUtils.copyProperties(packageItem, groupResponseDto);
                packageDtos.add(packageDto);
            }

            BeanUtils.copyProperties(eventPackage, packageDto);
            packageDtos.add(packageDto);
            LOGGER.info("Package List fetche");
        }

        return packageDtos;
    }

    @Override
    public PackageResponseDto getEventPackageByShortCode(String shortCode) {
        EventPackage eventPackage = eventPackageRepository.findOneByShortCode(shortCode);
//        List<PackageDto> packageDtos = new ArrayList();
        PackageResponseDto packageDto = new PackageResponseDto();
        for (Item packageItem : eventPackage.getPackageItems()) {
            ItemGroupResponseDto groupResponseDto = new ItemGroupResponseDto();
            for (Item groupItem : packageItem.getGroupItems()) {
                ItemResponseDto itemResponseDto = new ItemResponseDto();
                BeanUtils.copyProperties(groupItem, itemResponseDto);
                groupResponseDto.getItems().add(itemResponseDto);
            }
            BeanUtils.copyProperties(packageItem, groupResponseDto);
            packageDto.getPackageItems().add(groupResponseDto);
        }

        return packageDto;
    }

    @Override
    public ResponseEntity saveEventPackage(PackageItemDto packageItemDto, String user) {
        try {
            BaseResponceDto responceDto = new BaseResponceDto();
            LOGGER.info("Start to save Package : " + packageItemDto);
            EventPackage eventPackage = new EventPackage();
            BeanUtils.copyProperties(packageItemDto, eventPackage);
            Iterable<Item> items = itemRepository.findAllById(packageItemDto.getPackageItems());
            List<Item> itemList = Lists.newArrayList(items);
            eventPackage.setPackageItems(itemList);
            eventPackageRepository.save(eventPackage);

            responceDto.setErrorCode(HttpStatus.CREATED.value());
            responceDto.setErrorMessage(ResponseMessage.packageSavedSuccess);
            responceDto.setErrorType(StatusEnum.SUCCESS.toString());
            LOGGER.info("Package Saved successful");
            return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
        } catch (Exception e) {
            LOGGER.error("Error in Save Package", e);
            throw e;
        }
    }

    @Override
    public ResponseEntity updateEventPackage(PackageDto packageDto, String user) {
        try {
            BaseResponceDto responceDto = new BaseResponceDto();
            LOGGER.info("Start to Updsate Package : " + packageDto);
            Optional<EventPackage> eventPackageOp = eventPackageRepository.findById(packageDto.getId());
            if (eventPackageOp.isPresent()) {
                EventPackage eventPackage = eventPackageOp.get();
                BeanUtils.copyProperties(packageDto, eventPackage);
                Iterable<Item> items = itemRepository.findAllById(packageDto.getPackageItems());
                List<Item> itemList = Lists.newArrayList(items);
                eventPackage.setPackageItems(itemList);
                eventPackageRepository.save(eventPackage);

                responceDto.setErrorCode(HttpStatus.CREATED.value());
                responceDto.setErrorMessage(ResponseMessage.packageSavedSuccess);
                responceDto.setErrorType(StatusEnum.SUCCESS.toString());
                LOGGER.info("Package Saved successful");
                return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
            } else {
                responceDto.setErrorCode(HttpStatus.NOT_FOUND.value());
                responceDto.setErrorMessage("Package Not Found");
                responceDto.setErrorType(StatusEnum.ERROR.toString());
                LOGGER.info("Package Not Found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responceDto);
            }
        } catch (Exception e) {
            LOGGER.error("Error in update Package", e);
            throw e;
        }
    }
}
