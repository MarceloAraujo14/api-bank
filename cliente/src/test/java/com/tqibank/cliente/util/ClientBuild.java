package com.tqibank.cliente.util;

import com.tqibank.cliente.api.model.request.ClientRequest;
import com.tqibank.cliente.domain.entities.Client;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class ClientBuild {

    public static ClientRequest clientRequestToBeSaved() {
        return ClientRequest.builder()
                .email("dart-vader@gmail.com")
                .name("Anakin Skywalker")
                .cpf("53445151970")
                .rg("418757896")
                .income(new BigDecimal("5000"))
                .password("Estrel@daMort&")
                .adress("Galaxia Muito Distante, 42")
                .build();
    }

    public static Client clientToBeSaved() {
        return Client.builder()
                .email("dart-vader@gmail.com")
                .name("Anakin Skywalker")
                .cpf("53445151970")
                .rg("418757896")
                .income(new BigDecimal("5000"))
                .password("Estrel@daMort&")
                .adress("Galaxia Muito Distante, 42")
                .build();
    }

    public static ClientRequest clientToBeUpdate() {
        return ClientRequest.builder()
                .email("dart-vader@gmail.com")
                .name("Anakin Skywalker")
                .cpf("53445151970")
                .rg("418757896")
                .income(new BigDecimal("1000"))
                .password("Estrel@daMort&")
                .adress("Galaxia Muito Distante, 42")
                .build();
    }

}
