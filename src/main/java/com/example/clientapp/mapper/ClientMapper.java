package com.example.clientapp.mapper;

import com.example.clientapp.dto.ClientDTO;
import com.example.clientapp.model.Client;

public class ClientMapper {

    public static ClientDTO toDTO(Client client) {
        if (client == null) {
            return null;
        }
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setLastName(client.getLastName());
        dto.setContact(ContactMapper.toDTO(client.getContact()));
        return dto;
    }

    public static Client toEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setLastName(dto.getLastName());
        client.setContact(ContactMapper.toEntity(dto.getContact()));
        return client;
    }
}