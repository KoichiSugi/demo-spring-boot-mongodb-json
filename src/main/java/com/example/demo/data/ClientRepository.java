package com.example.demo.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, Integer> {
    @Query("{userId :?0}")
    Optional<List<Client>> findAllTicketsByUserId(int userId);

    @Override
    void deleteById(Integer integer);
}
