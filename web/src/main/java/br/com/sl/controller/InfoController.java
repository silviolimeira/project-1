package br.com.sl.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Controller
public class InfoController {

    /*
    Decode token to verify user and roles ...
     */
    @GetMapping("/info")
    public String info(HttpServletRequest request, HttpServletResponse response) {

        String authorizationHeader = request.getHeader(AUTHORIZATION);

        Algorithm algoritm = Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));
        JWTVerifier verifier = JWT.require(algoritm).build();
        DecodedJWT decodeJWT = verifier.verify(authorizationHeader);

        String tmp = decodeJWT.getSubject();
        String[] roles = decodeJWT.getClaim("roles").asArray(String.class);

        return tmp.toString();

    }

}