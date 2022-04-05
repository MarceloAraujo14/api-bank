package com.tqibank.cliente.api.model.request;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    @Id
    @Email
    @NotBlank
    @EqualsAndHashCode.Include
    private String email;

    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @NotNull
    private BigDecimal income;
    @NotBlank
    private String adress;
}
