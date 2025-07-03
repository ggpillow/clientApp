package com.example.clientapp.service;

import com.example.clientapp.exception.ContactNotFoundException;
import com.example.clientapp.model.Contact;
import com.example.clientapp.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    private Contact contact;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contact = new Contact();
        contact.setId(1L);
        contact.setPhone("+70001112233");
        contact.setEmail("test@test.ru");
    }

    @Test
    void getAllContacts() {
        List<Contact> contacts = List.of(contact);
        when(contactRepository.findAll()).thenReturn(contacts);

        List<Contact> result = contactService.getAllContact();

        assertEquals(1, result.size());
        assertEquals("+70001112233", result.get(0).getPhone());
        verify(contactRepository).findAll();
    }

    @Test
    void getContactById_found() {
        when(contactRepository.findById(1L)).thenReturn(Optional.of(contact));
        Contact found = contactService.getContactById(1L);
        assertEquals("test@test.ru", found.getEmail());
        verify(contactRepository).findById(1L);
    }

    @Test
    void getContactById_notFound() {
        when(contactRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ContactNotFoundException.class, () -> contactService.getContactById(2L));
        verify(contactRepository).findById(2L);
    }

    @Test
    void createContact() {
        when(contactRepository.save(any(Contact.class))).thenReturn(contact);
        Contact saved = contactService.createContact(contact);
        assertNotNull(saved);
        verify(contactRepository).save(contact);
    }
}