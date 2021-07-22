package com.example.demo;

import com.example.demo.data.Client;
import com.example.demo.data.ClientRepository;
import com.example.demo.service.ServiceImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    private static final File clientRecords = new File("src/main/resources/clientRecords.json");
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ServiceImpl.class);

    static {
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ClientRepository clientRepository, MongoTemplate mongoTemplate) {
        return args -> {
            List<Client> clients = Arrays.asList(mapper.treeToValue(mapper.readTree(clientRecords).get("client"), Client[].class));
            logger.info(clients.toString());

            for (int i = 0; i < clients.size(); i++) {
                if (!clientRepository.findById(clients.get(i).getTicket()).isPresent()) {
                    clientRepository.insert(clients.get(i));
                }
            }
        };
    }
}
