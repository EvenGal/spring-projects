package com.evengal.service;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldService {

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<String>("Hello!", HttpStatusCode.valueOf(200));
    }
}
