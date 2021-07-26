package com.example.demo.rest;

import com.example.demo.data.Client;
import com.example.demo.data.ClientRepository;
import com.example.demo.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final Service service;
    private final ClientRepository clientRepository;

    @GetMapping("")
    public List<Client> showAllClient() { return service.getAllClients(); }

    @GetMapping("{ticketId}")
    public ResponseEntity<Client> findClient(@PathVariable int ticketId) {
        Optional<Client> client = clientRepository.findById(ticketId);
        if (!client.isEmpty()) {
            System.out.println(client);
            return new ResponseEntity<Client>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }
}
