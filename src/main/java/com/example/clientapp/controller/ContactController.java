package com.example.clientapp.controller;

import com.example.clientapp.dto.ContactDTO;
import com.example.clientapp.mapper.ContactMapper;
import com.example.clientapp.model.Contact;
import com.example.clientapp.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDTO> getAllContacts() {
        return contactService.getAllContact().stream()
                .map(ContactMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ContactDTO getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        return ContactMapper.toDTO(contact);
    }

    @PostMapping
    public ContactDTO createContact(@Valid @RequestBody ContactDTO contactDTO) {
        Contact contact = ContactMapper.toEntity(contactDTO);
        Contact saved = contactService.createContact(contact);
        return ContactMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public ContactDTO updateContact(@PathVariable Long id, @Valid @RequestBody ContactDTO contactDTO) {
        Contact contactToUpdate = ContactMapper.toEntity(contactDTO);
        contactToUpdate.setId(id);
        Contact updated = contactService.updateContact(id, contactToUpdate);
        return ContactMapper.toDTO(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}