package com.tqibank.servico.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Value("${topic.emprestimo-cliente}")
    private String loanApplication;

    public NewTopic solicitacao(){
        return new NewTopic(loanApplication, 3, (short) 1);
    }

}
