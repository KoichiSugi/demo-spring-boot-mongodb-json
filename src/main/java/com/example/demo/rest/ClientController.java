package com.example.demo.rest;

import com.example.demo.data.Client;
import com.example.demo.data.ClientRepository;
import com.example.demo.service.Service;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/")
public class ClientController {

    private final Service service;
    private final ClientRepository clientRepository;
    private static final Logger logger = Logger.getLogger(ClientController.class.getName());

    @GetMapping("clients")
    public List<Client> showAllClient() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/tickets/{userId}")
    public Optional<List<Client>> findAllTicketsByUserId(@PathVariable int userId) {
        return clientRepository.findAllTicketsByUserId(userId);
    }

    @GetMapping("/clients/{ticketId}")
    public ResponseEntity<Client> findClientByTicket(@PathVariable int ticketId) {
        //search ticket by ticketID
        Optional<Client> client = clientRepository.findById(ticketId);
        if (!client.isEmpty()) {
            logger.info(client.toString());
            return new ResponseEntity<Client>(client.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    @SneakyThrows
    @PostMapping("/clients")
    public Client createTicket(@RequestBody Client client) {
        return this.clientRepository.save(client);
    }

    @SneakyThrows
    @DeleteMapping("/clients/{ticketId}")
    public Map<String, Boolean> DeleteTicket(@PathVariable int ticketId) throws ResourceNotFoundException {
        Client clients = clientRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("ticket id " + ticketId + ": not found"));
        clientRepository.deleteById(ticketId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @SneakyThrows
    @PutMapping("/clients/{ticketId}")
    public ResponseEntity<Client> UpdateTicket(@PathVariable int ticketId, @RequestBody Client clientDetails) {
        Client client = clientRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("ticket id " + ticketId + ": not found"));
        client.setCloseTime(clientDetails.getCloseTime());
        client.setCommission(clientDetails.getCommission());
        client.setSwaps(clientDetails.getSwaps());
        client.setProfit(clientDetails.getProfit());
        client.setComment(clientDetails.getComment());
        return ResponseEntity.ok(this.clientRepository.save(client));
    }
}
