package com.tqibank.cliente.api.mapper;

import com.tqibank.cliente.api.model.request.ClientRequest;
import com.tqibank.cliente.api.model.response.ClientResponse;
import com.tqibank.cliente.domain.entities.Client;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClientMapper {


    public ModelMapper modelMapper;


    public Client toEntity (ClientRequest request){
        return modelMapper.map(request, Client.class);
    }

    public ClientResponse toModel (Client client){
        return modelMapper.map(client, ClientResponse.class);
    }

    public List<ClientResponse> toCollectionList(List<Client> clients){
        return clients.stream().map(this::toModel).collect(Collectors.toList());
    }

}
