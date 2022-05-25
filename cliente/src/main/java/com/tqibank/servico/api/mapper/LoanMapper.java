package com.tqibank.servico.api.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tqibank.servico.api.model.request.LoanApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    @Autowired
    public ObjectMapper mapper;

    public String loanRequestToString(LoanApplicationRequest request) throws JsonProcessingException {
        return mapper.writeValueAsString(request);
    }

}
