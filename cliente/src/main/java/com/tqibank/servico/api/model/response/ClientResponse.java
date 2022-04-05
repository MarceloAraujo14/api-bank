package com.tqibank.servico.api.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
