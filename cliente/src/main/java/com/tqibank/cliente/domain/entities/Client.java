package com.tqibank.cliente.domain.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @EqualsAndHashCode.Include
    private String email;
    private String password;
    private String name;
    private String cpf;
    private String rg;
    private BigDecimal income;
    private String adress;
}
