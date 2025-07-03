package com.example.clientapp.controller;

import com.example.clientapp.dto.ClientDTO;
import com.example.clientapp.mapper.ClientMapper;
import com.example.clientapp.model.Client;
import com.example.clientapp.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients().stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return ClientMapper.toDTO(client);
    }

    @PostMapping
    public ClientDTO createClient(@Valid @RequestBody ClientDTO clientDTO) {
        Client client = ClientMapper.toEntity(clientDTO);
        Client saved = clientService.createClient(client);
        return ClientMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {
        Client clientToUpdate = ClientMapper.toEntity(clientDTO);
        clientToUpdate.setId(id);
        Client updated = clientService.updateClient(id, clientToUpdate);
        return ClientMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}