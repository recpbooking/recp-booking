/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recp.recpbooking.services;

import com.recp.recpbooking.common.StatusEnum;
import com.recp.recpbooking.dto.PackageDto;
import com.recp.recpbooking.dto.PackageItemDto;
import com.recp.recpbooking.dto.PackageResponseDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Roshan_inova
 */
public interface EventPackageService {

    public List<?> getEventPackageList();

    public PackageResponseDto getEventPackageByShortCode(String shortCode);

    public ResponseEntity saveEventPackage(PackageItemDto packageItemDto, String user);
    
    public ResponseEntity updateEventPackage(PackageDto packageDto, String user) throws Exception;

    public List<?> getEventPackageByStatuses(StatusEnum[] statuses);
}
