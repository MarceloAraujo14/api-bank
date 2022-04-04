package com.tqibank.servico.domain.service;

import com.tqibank.servico.api.model.request.LoanApplicationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoanService {

    @Value("${topic.emprestimo-cliente}")
    private String topicLoanApplication;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(String request){
        log.info("Loan service do servico {}", request);
        this.kafkaTemplate.send(topicLoanApplication, request);
        log.info("Send to topic_emprestimo-cliente: {}", request);
    }

}
