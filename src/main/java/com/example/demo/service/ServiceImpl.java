package com.example.demo.service;

import com.example.demo.data.Client;
import com.example.demo.data.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements Service {
    private final ClientRepository clientRepository;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ServiceImpl.class);

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findTicketByUserId(int userId) {
        return null;
    }
}
