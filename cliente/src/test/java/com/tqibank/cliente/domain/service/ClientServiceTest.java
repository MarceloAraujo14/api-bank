package com.tqibank.cliente.domain.service;

import com.tqibank.cliente.api.mapper.ClientMapper;
import com.tqibank.cliente.api.model.request.ClientRequest;
import com.tqibank.cliente.domain.entities.Client;
import com.tqibank.cliente.domain.repository.ClientRepository;
import com.tqibank.cliente.util.ClientBuild;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    @Mock
    private ClientMapper mapper;

    @InjectMocks
    private ClientService underTest;

    @DisplayName("Deveria cadastrar um cliente e retornar ok")
    @Test
    void create() {
        //given
        ClientRequest clientToSave = ClientBuild.clientRequestToBeSaved();
        //when
        when(repository.save((Client) any())).thenReturn(null);
        ResponseEntity<String> result = this.underTest.create(clientToSave);
        ResponseEntity<String> expect = ResponseEntity.ok("Cliente cadastrado com sucesso.");
        //then
        assertThat(result).isEqualTo(expect);
        verify(repository, times(1)).save((Client) any());
    }
    @DisplayName("Deve atualizar cliente e retornar ok")
    @Test
    void update() throws EntityNotFoundException {
        //given
        Client clientFind = ClientBuild.toBeSaved();
        ClientRequest clientToUpdate = ClientBuild.toBeUpdate();
        String email = "dart-vader@gmail.com";
        //when
        when(repository.save((Client) any())).thenReturn(null);
        when(repository.findById(email)).thenReturn(Optional.of(clientFind));
        ResponseEntity<String> result = this.underTest.update(clientToUpdate, email);
        ResponseEntity<String> expect = ResponseEntity.ok("Dados atualizados com sucesso.");
        //then
        assertThat(result).isEqualTo(expect);
        verify(repository,times(1)).findById(email);
        verify(repository, times(1)).save(mapper.toEntity(clientToUpdate));
    }

    @DisplayName("Deve lançar exception quando não localiza cliente")
    @Test
    void update2() throws EntityNotFoundException {
        //given

        ClientRequest clientToUpdate = ClientBuild.toBeUpdate();
        String email = "marcelo@gmail.com";
        //when

        when(repository.findById(email)).thenReturn(Optional.empty());


        //then
        assertThatThrownBy(() -> underTest.update(clientToUpdate,email))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining("Cliente não encontrado.");

        verify(repository,times(1)).findById(email);
        verify(repository,times(0)).save(any());

    }


    @DisplayName("Deve deletar cliente e retornar ok")
    @Test
    void delete() throws EntityNotFoundException {
        //given
        Client clientFind = ClientBuild.toBeSaved();

        String email = "dart-vader@gmail.com";
        //when

        when(repository.findById(email)).thenReturn(Optional.of(clientFind));


        ResponseEntity<String> result = this.underTest.delete(email);
        ResponseEntity<String> expect = ResponseEntity.ok("Cliente deletado com sucesso.");
        //then
        assertThat(result).isEqualTo(expect);

        verify(repository,times(1)).findById(email);
        verify(repository,times(1)).deleteById(email);

    }





}
