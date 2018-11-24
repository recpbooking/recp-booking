/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.controller;

import com.recp.recpbooking.common.ResponseMessage;
import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.BaseResponceDto;
import com.recp.recpbooking.dto.PackageDto;
import com.recp.recpbooking.dto.PackageItemDto;
import com.recp.recpbooking.dto.PackageResponseDto;
import com.recp.recpbooking.services.EventPackageService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roshan_inova
 */
@RestController
@RequestMapping("${rbs.event-package.api.url}")
public class EventPackageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventPackageController.class);

    @Autowired
    EventPackageService eventPackageService;

    @GetMapping("/")
    public ResponseEntity<?>
            getPackageList() {
        LOGGER.info("Package List fetching Start");
        List<?> eventPackageDtos = eventPackageService.getEventPackageList();
        LOGGER.info("Package List successfuly Fetched");
        return ResponseEntity.ok(eventPackageDtos);
    }

    @GetMapping("/byshortcode/{short_code}")
    public ResponseEntity<?>
            getPackageByShortCode(@PathVariable(name = "short_code") String shortCode) {
        LOGGER.info("Package List fetching Start");
        PackageResponseDto packageResponseDto = eventPackageService.getEventPackageByShortCode(shortCode);
        if (packageResponseDto != null) {
            LOGGER.info("Package List successfuly Fetched");
            return ResponseEntity.ok(packageResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Item short code");
        }
    }
            
    @GetMapping("/bystatus")
    public ResponseEntity<?>
            getPackageByStatus(@RequestParam StatusEnum[] statuses) {
        LOGGER.info("Package List fetching Start");
        List<?> eventPackageDtos = eventPackageService.getEventPackageByStatuses(statuses);
        if (eventPackageDtos != null) {
            LOGGER.info("Package List successfuly Fetched");
            return ResponseEntity.ok(eventPackageDtos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Recods Found");
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> addPackage(@RequestBody PackageItemDto packageItemDto) {
        String user = "";
        try {
            LOGGER.info("Package Creation Start");
            ResponseEntity responseEntity = eventPackageService.saveEventPackage(packageItemDto, user);
            LOGGER.info("Package Created successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Package creation error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.packageSavedFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updatePackage(@RequestBody PackageDto packageDto) {
        String user = "";
        try {
            LOGGER.info("Package Updated Start");
            ResponseEntity responseEntity = eventPackageService.updateEventPackage(packageDto, user);
            LOGGER.info("Package Updated successfuly");
            return responseEntity;
        } catch (Exception e) {
            LOGGER.error("Package Updating error", e);
            BaseResponceDto responceDto = new BaseResponceDto();
            responceDto.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
            responceDto.setErrorMessage(ResponseMessage.packageUpdatingFailed);
            responceDto.setErrorType(StatusEnum.ERROR.toString());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(responceDto);
        }
    }
}
