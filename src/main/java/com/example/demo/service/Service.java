package com.example.demo.service;


import com.example.demo.data.Client;

import java.util.List;

public interface Service {
    List<Client> getAllClients();
    List<Client> findTicketByUserId(int userId);
}
