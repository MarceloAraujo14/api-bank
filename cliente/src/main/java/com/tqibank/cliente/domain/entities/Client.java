package com.tqibank.cliente.domain.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return email != null && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
