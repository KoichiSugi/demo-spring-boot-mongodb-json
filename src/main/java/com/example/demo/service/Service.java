package com.example.demo.service;


import com.example.demo.data.Client;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface Service {
    Optional<Client> findByTicketId(@NonNull int ticketId);
    List<Client> getAllClients();
}
