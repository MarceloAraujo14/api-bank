package com.tqibank.cliente.util;

import com.tqibank.cliente.domain.entities.Client;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class ClientBuild {

    public static Client ClientToBeSaved(){
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

}
