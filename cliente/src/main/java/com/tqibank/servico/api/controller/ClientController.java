package com.tqibank.servico.api.controller;

import com.tqibank.servico.api.model.request.ClientRequest;
import com.tqibank.servico.api.model.response.ClientResponse;
import com.tqibank.servico.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/{email}")
    public ResponseEntity update (@PathVariable String email, @RequestBody ClientRequest request){
        return service.update(request,email);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity delete (@PathVariable String email){
        return service.delete(email);
    }


}
