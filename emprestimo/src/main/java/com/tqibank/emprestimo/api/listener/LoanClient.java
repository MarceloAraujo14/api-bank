package com.tqibank.emprestimo.api.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tqibank.emprestimo.api.mapper.LoanMapper;
import com.tqibank.emprestimo.domain.entity.LoanApplication;
import com.tqibank.emprestimo.domain.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoanClient {

    @Autowired
    private LoanService service;

    @Autowired
    private LoanMapper mapper;

    @KafkaListener(topics = "${topic.emprestimo-cliente}", groupId = "${spring.kafka.consumer.group-id}")
    public void getLoan(String request) throws JsonProcessingException {
        log.info("Loan Request: {}", request);
        LoanApplication application = mapper.stringToApplication(request);
        log.info("LoanClient after mapper application {}", application);
        service.create(application);
        log.info("create sucess.");
    }

}
