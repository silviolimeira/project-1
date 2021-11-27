package com.sl.jpa.controller;

import com.sl.jpa.AccessingDataJpaApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class InfoController {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    /*
    Decode token to verify user and roles ...
     */
    @GetMapping("/info")
    public String hello() {
        log.info("Hello !");
        return "Hello";
    }
}
