package com.tqibank.servico.domain.repository;

import com.tqibank.servico.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Client findByCpf(String cpf);
    Client findByRg(String cpf);
    Client findByEmail(String email);
}
