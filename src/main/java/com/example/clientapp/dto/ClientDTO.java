package com.example.clientapp.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClientDTO {
    private Long id;

    @NotBlank(message = "Имя обязательно")
    @Size(max = 30, message = "Имя не должно превышать 30 символов")
    private String name;

    @NotBlank(message = "Фамилия обязательна")
    @Size(max = 50, message = "Фамилия не должна первышать 50 символов")
    private String lastName;

    @Valid
    private ContactDTO contact;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactDTO getContact() {
        return contact;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }
}
