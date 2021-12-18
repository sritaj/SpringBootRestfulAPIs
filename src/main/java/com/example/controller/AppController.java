package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class AppController {

    Logger logger = LoggerFactory.getLogger(AppController.class);

    @Value("${app.name:Default Demo App}")
    private String appName;

    @GetMapping("/")
    public String getAppName() {
        return appName;
    }

    @GetMapping("getSample")
    public String getSample(){
        logger.error("Inside error");
        logger.warn("Inside error");
        logger.info("Inside info");
        logger.debug("Inside debug");
        logger.trace("Inside trace");
        String example = "Example";
        return example;
    }
}
