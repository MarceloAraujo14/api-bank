package com.tqibank.cliente.domain.repository;

import com.tqibank.cliente.domain.entities.Client;
import com.tqibank.cliente.util.ClientBuild;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DisplayName("Teste de repositório de cliente")
@DataJpaTest
class RepositoryTest {

    private final ClientRepository repository;

    @Autowired
    public RepositoryTest(ClientRepository repository) {
        this.repository = repository;
    }

    @Test
    @DisplayName("Deveria encontrar um cliente pelo cpf")
    void findByCpf(){
        //given
        Client client = ClientBuild.ClientToBeSaved();
        String cpf = "53445151970";
        this.repository.save(client);
        //when
        Client result = this.repository.findByCpf(cpf);
        //then
        assertThat(result).isEqualTo(client);
    }

    @Test
    @DisplayName("Deveria retornar erro ao buscar um cliente por cpf nao cadastrado")
    void findByCpf2(){
        //given
        Client client = ClientBuild.ClientToBeSaved();
        String cpf = "53445151971";
        this.repository.save(client);
        //when
        Client result = this.repository.findByCpf(cpf);
        //then
        assertThat(result).isNull();
    }

    @Test
    @DisplayName("Deveria encontrar um cliente pelo rg")
    void findByRg(){
        //given
        Client client = ClientBuild.ClientToBeSaved();
        String rg = "418757896";
        this.repository.save(client);
        //when
        Client result = this.repository.findByRg(rg);
        //then
        assertThat(result).isEqualTo(client);
    }

    @Test
    @DisplayName("Deveria retornar erro ao buscar um cliente por rg nao cadastrado")
    void findByRg2(){
        //given
        Client client = ClientBuild.ClientToBeSaved();
        String rg = "418757897";
        this.repository.save(client);
        //when
        Client result = this.repository.findByRg(rg);
        //then
        assertThat(result).isNull();
    }

    @Test
    @DisplayName("Deveria encontrar um cliente pelo email")
    void findByEmail(){
        //given
        Client client = ClientBuild.ClientToBeSaved();
        String email = "dart-vader@gmail.com";
        this.repository.save(client);
        //when
        Client result = this.repository.findByEmail(email);
        //then
        assertThat(result).isEqualTo(client);
    }

    @Test
    @DisplayName("Deveria retornar erro ao buscar um cliente por email nao cadastrado")
    void findByEmail2(){
        //given
        Client client = ClientBuild.ClientToBeSaved();
        String email = "dart-vr@gmail.com";
        this.repository.save(client);
        //when
        Client result = this.repository.findByEmail(email);
        //then
        assertThat(result).isNull();
    }


}
