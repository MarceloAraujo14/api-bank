package com.tqibank.servico.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tqibank.servico.api.mapper.LoanMapper;
import com.tqibank.servico.api.model.request.LoanApplicationRequest;
import com.tqibank.servico.domain.service.LoanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/v1/emprestimo")
public class LoanController {

    private final LoanService loanService;
    @Autowired
    private LoanMapper mapper;

    @PostMapping()
    public ResponseEntity<String> loanApplication(@Valid @RequestBody LoanApplicationRequest request) throws JsonProcessingException {
        request.setClientId("dard-vader@gmail.com");
        log.info("Loan application: {}", request);
        String requestString = mapper.loanRequestToString(request);
        loanService.sendMsg(requestString);
        return ResponseEntity.ok("Sucess Request.");
    }

}
