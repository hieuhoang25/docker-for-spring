package com.hicode.dockerspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HomeController {

    @Value("${content.myapi}")
    private String myapi;

    @Value("${content.param}")
    private String param;
    @GetMapping("/myapi")
    public ResponseEntity<?> getContentAPI(){
        return ResponseEntity.ok(myapi);
    }

    @GetMapping("/param")
    public ResponseEntity<?> getContentParam(){
        return ResponseEntity.ok(param);
    }
}
