package com.example.demo.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, Integer> {
    Optional<Client> findClientByTicket(int ticket);

//    @Override
//    void deleteById(Integer integer);
}
