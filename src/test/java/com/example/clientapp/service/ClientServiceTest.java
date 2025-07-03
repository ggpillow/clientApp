package com.example.clientapp.service;

import com.example.clientapp.exception.ClientNotFoundException;
import com.example.clientapp.model.Client;
import com.example.clientapp.repository.ClientRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client();
        client.setId(1L);
        client.setName("Anna");
        client.setLastName("Volkova");
    }

    @Test
    void getAllClients() {
        List<Client> clients = List.of(client);
        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.getAllClients();

        assertEquals(1, result.size());
        assertEquals("Anna", result.get(0).getName());
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void getClientById_found() {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        Client found = clientService.getClientById(1L);
        assertEquals("Anna", found.getName());
        verify(clientRepository).findById(1L);
    }

    @Test
    void getClientById_notFound() {
        when(clientRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ClientNotFoundException.class, () -> clientService.getClientById(2L));
        verify(clientRepository).findById(2L);
    }

    @Test
    void createClient() {
        when(clientRepository.save(any(Client.class))).thenReturn(client);
        Client saved = clientService.createClient(client);
        assertNotNull(saved);
        verify(clientRepository).save(client);
    }
}
