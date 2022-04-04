package com.tqibank.emprestimo.api.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tqibank.emprestimo.api.model.LoanApplicationRequest;
import com.tqibank.emprestimo.api.model.LoanApplicationResponse;
import com.tqibank.emprestimo.domain.entity.LoanApplication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    public ModelMapper mapper;

    public LoanApplication toLoanApplication(LoanApplicationRequest request){
        return mapper.map(request, LoanApplication.class);
    }

    public LoanApplicationResponse toResponse(LoanApplication application){
        return mapper.map(application, LoanApplicationResponse.class);
    }

    public LoanApplication stringToApplication(String request) throws JsonProcessingException {

        return objectMapper.readValue(request, LoanApplication.class);
    }

}
