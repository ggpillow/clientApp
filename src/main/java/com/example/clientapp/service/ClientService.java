package com.example.clientapp.service;

import com.example.clientapp.exception.ClientNotFoundException;
import com.example.clientapp.model.Client;
import com.example.clientapp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository  = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById (Long id) {
        return clientRepository.findById(id)
                .orElseThrow(()->new ClientNotFoundException("Клиент с id " + id + " не найден"));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client existingClient = getClientById(id);
        existingClient.setName(updatedClient.getName());
        existingClient.setLastName(updatedClient.getLastName());

        return clientRepository.save(existingClient);
    }

    public void deleteClient(Long id) {
        Client existingClient = getClientById(id);
        clientRepository.delete(existingClient);
    }

}
