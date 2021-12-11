package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AppController {

    @Value("${app.name:Default Demo App}")
    private String appName;

    @GetMapping("/")
    public String getAppName(){
        return appName;
    }
}
