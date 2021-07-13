package com.example.demo.service;

import com.example.demo.data.Client;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ServiceImpl implements Service {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final File clientRecords = new File("src/main/resources/clientsRecords.json");

    static {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    @Override
    @SneakyThrows(IOException.class)
    public void deserializeJson() {
        List<Client> clients = Arrays.asList(mapper.treeToValue(mapper.readTree(clientRecords).get("rows"), Client[].class));
    }
}
