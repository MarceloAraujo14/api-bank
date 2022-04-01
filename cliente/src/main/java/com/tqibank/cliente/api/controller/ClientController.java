package com.tqibank.cliente.api.controller;

import com.tqibank.cliente.api.model.request.ClientRequest;
import com.tqibank.cliente.api.model.response.ClientResponse;
import com.tqibank.cliente.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cliente")
@AllArgsConstructor
public class ClientController {

    private final ClientService service;


    @GetMapping()
    public List<ClientResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("/{email}")
    public ResponseEntity findClient (@PathVariable String email){
        return service.findByID(email);
    }

    @PostMapping()
    public ResponseEntity create (@RequestBody @Valid ClientRequest request){
        return service.create(request);
    }

    @PutMapping("/{email}")
    public ResponseEntity update (@PathVariable String email, @RequestBody ClientRequest request){
        return service.update(request,email);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity delete (@PathVariable String email){
        return service.delete(email);
    }


}
