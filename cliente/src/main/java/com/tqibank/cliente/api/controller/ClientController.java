package com.tqibank.cliente.api.controller;

import com.tqibank.cliente.api.model.request.ClientRequest;
import com.tqibank.cliente.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cliente")
@AllArgsConstructor
public class ClientController {

    private final ClientService service;


    @PostMapping()
    public ResponseEntity create (@RequestBody @Valid ClientRequest request){
        return service.create(request);
    }


}
