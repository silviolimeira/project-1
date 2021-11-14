package com.sl.jwt.controller;

import com.sl.jwt.domain.Student;
import com.sl.jwt.service.APIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ApiCacheController {

    @Autowired
    private APIService aPIService;

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    @CrossOrigin(origins="http://localhost:8080")
    @GetMapping(value = "/student")
    @ResponseBody
    public ResponseEntity<Student> fetchStudent(@RequestParam(name = "studentId") String studentId,
                                                @RequestParam(name = "isCacheable") boolean isCacheable) throws InterruptedException {
        return new ResponseEntity<>(aPIService.fetchStudent(studentId, isCacheable).get(), HttpStatus.OK);
    }

    @GetMapping(value = "/tststudent")
    public String tstStudent() {
        return "tstStudent OK!";
    }

    @GetMapping(value = "/error")
    public String getDefaultErrorMessage() {

        int b = 2;
        if (b == 2) {
            throw new RuntimeException("Show Default Error Message Handler");
        }

        return "OK";

    }
}

