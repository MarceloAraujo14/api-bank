package com.tqibank.cliente.domain.service;

import com.tqibank.cliente.domain.entities.Client;
import com.tqibank.cliente.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<String> create(Client client) {
        repository.save(client);
        return ResponseEntity.ok("Cliente cadastrado com sucesso.");
    }


}
