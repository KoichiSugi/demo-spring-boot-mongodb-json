package com.example.demo.rest;

import com.example.demo.data.Client;
import com.example.demo.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ClientController {

    private final Service service;


    @GetMapping("")
    ResponseEntity<Client> deserializeUser(){
        service.deserializeJson();
        return ResponseEntity.ok(null);
    }



}
