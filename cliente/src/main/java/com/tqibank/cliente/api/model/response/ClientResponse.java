package com.tqibank.cliente.api.model.response;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
public class ClientResponse {


    private String email;
    private String name;
    private String cpf;
    private String rg;
    private BigDecimal income;
    private String adress;
}
