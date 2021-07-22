package com.example.demo.service;

import com.example.demo.data.Client;
import com.example.demo.data.ClientRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements Service {
    private final ClientRepository clientRepository;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ServiceImpl.class);

    @Override
    public Optional<Client> findByTicketId(@NonNull int ticketId) {
        return clientRepository.findById(ticketId);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
