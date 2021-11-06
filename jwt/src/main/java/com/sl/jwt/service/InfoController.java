package com.sl.jwt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/info")
    public void infoGetMethod() {
        System.out.println(String.format("\n>>> Server port: %d\n", serverPort));
    }

}
