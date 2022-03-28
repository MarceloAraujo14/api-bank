package com.tqibank.cliente.domain.service;

import com.tqibank.cliente.api.mapper.ClientMapper;
import com.tqibank.cliente.api.model.request.ClientRequest;
import com.tqibank.cliente.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;

    private final ClientMapper mapper;

    @Autowired
    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ResponseEntity<String> create(ClientRequest clientRequest) {

        repository.save(mapper.toEntity(clientRequest));

        return ResponseEntity.ok("Cliente cadastrado com sucesso.");
    }


}
