package com.example.demo.service;

import com.example.demo.data.Client;
import com.example.demo.data.ClientRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements Service {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final File clientRecords = new File("src/main/resources/clientRecords.json");
    private final ClientRepository clientRepository;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ServiceImpl.class);

    static {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    @Override
    @SneakyThrows(IOException.class)
    public void deserializeJson() {
        logger.info("test");
        List<Client> clients = Arrays.asList(mapper.treeToValue(mapper.readTree(clientRecords).get("rows"), Client[].class));
        logger.info(clients.toString());

        for (int i = 0; i < clients.size(); i++) {
            clientRepository.insert(clients.get(i));
        }
    }
}
