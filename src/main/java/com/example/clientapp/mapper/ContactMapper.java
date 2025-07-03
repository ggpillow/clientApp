package com.example.clientapp.mapper;

import com.example.clientapp.dto.ContactDTO;
import com.example.clientapp.model.Contact;

public class ContactMapper {

    public static ContactDTO toDTO(Contact contact) {
        if (contact == null) {
            return null;
        }
        ContactDTO dto = new ContactDTO();
        dto.setId(contact.getId());
        dto.setPhone(contact.getPhone());
        dto.setEmail(contact.getEmail());
        return dto;
    }

    public static Contact toEntity(ContactDTO dto) {
        if (dto == null) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(dto.getId());
        contact.setPhone(dto.getPhone());
        contact.setEmail(dto.getEmail());
        return contact;
    }
}