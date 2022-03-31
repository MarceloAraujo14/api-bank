package com.tqibank.cliente.domain.service;


import com.tqibank.cliente.api.mapper.ClientMapper;
import com.tqibank.cliente.api.model.request.ClientRequest;
import com.tqibank.cliente.api.model.response.ClientResponse;
import com.tqibank.cliente.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    private final ClientMapper mapper;

    @Autowired
    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<ClientResponse> findAll(){
        return mapper.ToCollectionList(repository.findAll());
    }

    public ResponseEntity<String> findByID(String email) throws EntityNotFoundException{
        ClientResponse cliente = mapper.toModel(repository.findById(email).orElseThrow(() ->
                new EntityNotFoundException("Cliente não localizado")));
        return ResponseEntity.ok(cliente.toString());
    }

    @Transactional
    public ResponseEntity<String> create(ClientRequest clientRequest) {

        repository.save(mapper.toEntity(clientRequest));

        return ResponseEntity.ok("Cliente cadastrado com sucesso.");
    }

    @Transactional
    public ResponseEntity<String> update(ClientRequest clientToUpdate, String email) throws EntityNotFoundException {

        repository.findById(email).orElseThrow(() ->
                new EntityNotFoundException("Cliente não encontrado."));

        clientToUpdate.setEmail(email);

        repository.save(mapper.toEntity(clientToUpdate));

        return ResponseEntity.ok("Dados atualizados com sucesso.");
    }

    //@Transactional
    public ResponseEntity<String> delete(String email) throws EntityNotFoundException  {
        repository.findById(email).orElseThrow(() ->
                new EntityNotFoundException("Cliente não encontrado."));
        repository.deleteById(email);
        return ResponseEntity.ok("Cliente deletado com sucesso.");
    }
}
