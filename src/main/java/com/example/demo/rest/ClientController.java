package com.example.demo.rest;

import com.example.demo.data.Client;
import com.example.demo.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClientController {

    private final Service service;


    @GetMapping("")
    ResponseEntity<Client> deserializeUser() {
        service.deserializeJson();
        return ResponseEntity.ok(null);
    }

    @GetMapping()
    public List<Client> showAllClient(){
        return service.getAllClients();
    }


}
