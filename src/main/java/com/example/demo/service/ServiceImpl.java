package com.example.demo.service;

import com.example.demo.data.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements Service {
    private final ClientRepository clientRepository;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ServiceImpl.class);
}
