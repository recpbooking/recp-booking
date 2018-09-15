package com.recp.recpbooking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hi")
    public ResponseEntity<?> sayHi() {
        return ResponseEntity.ok("Hiiii...");
    }
}
