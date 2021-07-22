package com.example.demo.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, Integer> {
    Optional<Client> findClientByUserId(int userId);
}
