package com.example.clientapp.service;

import com.example.clientapp.exception.ContactNotFoundException;
import com.example.clientapp.model.Contact;
import com.example.clientapp.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    public Contact getContactById (Long id) {
        return contactRepository.findById(id)
                .orElseThrow(()-> new ContactNotFoundException("Контакт с id " + id + "не найден"));
    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact updateContact) {
        Contact existingContact = getContactById(id);
        existingContact.setPhone(updateContact.getPhone());
        existingContact.setEmail(updateContact.getEmail());

        return contactRepository.save(existingContact);
    }

    public void deleteContact(Long id) {
        Contact contact = getContactById(id);
        contactRepository.delete(contact);
    }
}
