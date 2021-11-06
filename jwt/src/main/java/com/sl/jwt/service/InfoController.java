package com.sl.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sl.jwt.config.YamlPropertySourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:application.yml", factory= YamlPropertySourceFactory.class)
public class InfoController {

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${spring.profiles.active}")
    private String springProfiles;


    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public String infoGetMethod() {

        System.out.println(String.format("\n>>> Server port: %d\n", serverPort));
        System.out.println("sprintProfies " + springProfiles);

        return String.format("{ \"sprintProfies\": \"%s\" }", springProfiles);
    }

}
