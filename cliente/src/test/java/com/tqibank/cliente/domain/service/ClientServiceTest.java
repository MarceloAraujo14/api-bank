package com.tqibank.cliente.domain.service;

import com.tqibank.cliente.api.mapper.ClientMapper;
import com.tqibank.cliente.api.model.request.ClientRequest;
import com.tqibank.cliente.domain.entities.Client;
import com.tqibank.cliente.domain.repository.ClientRepository;
import com.tqibank.cliente.util.ClientBuild;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ClientService.class})
@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    // Lista de testes
    /*
    -Testes unitários
        O que deve ser testado:
        - Salvar um cliente
        - Atualizar um cliente
        - Deletar um cliente por email
        - Retornar cliente por email
        - Retornar cliente por cpf
        - Retornar um cliente por rg
        - Não salvar um cliente com dado obrigatório faltando;
        - Não salvar um cliente com email repetido;
        - Não salvar um cliente com cpf repetido;
        - Não salvar um cliente com rg repetido;
    */

    @Mock
    private ClientRepository repository;

    private ClientMapper mapper;

    @InjectMocks
    private ClientService underTest;

    @DisplayName("Deveria cadastrar um cliente e retornar ok")
    @Test
    void create() {
        //given
        ClientRequest ClienttoMapper =
        Client clientToSave = ClientBuild.clientRequestToBeSaved();
        //when
        when(repository.save((Client) any())).thenReturn(clientToSave);
        ResponseEntity<String> result = this.underTest.create(clientToSave);
        ResponseEntity<String> expect = ResponseEntity.ok("Cliente cadastrado com sucesso.");
        //then
        assertThat(result).isEqualTo(expect);
        verify(repository, times(1)).save(clientToSave);
    }

    @Test
    void update() {
        //given
        ClientRequest clientToSave = ClientBuild.clientToBeSaved();
        ClientRequest clientToUpdate = ClientBuild.clientToBeSaved();
        //when
        when(repository.save((Client) any())).thenReturn((Client) any());
        ResponseEntity<String> result = this.underTest.create(clientToSave);
        ResponseEntity<String> expect = ResponseEntity.ok("Cliente cadastrado com sucesso.");
        //then
        assertThat(result).isEqualTo(expect);
        verify(repository, times(1)).save(clientToSave);
    }

}
