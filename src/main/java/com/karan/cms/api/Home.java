package com.karan.cms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController

public class Home {

    @GetMapping
    public String home(){
        return "Application Working " + new Date();
    }
}