package com.tqibank.cliente.domain.repository;

import com.tqibank.cliente.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Client findByCpf(String cpf);
    Client findByRg(String cpf);

}
