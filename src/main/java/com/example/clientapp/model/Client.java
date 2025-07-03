package com.example.clientapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name= "client_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "name", length = 30, nullable = false, unique = false)
    private String name;

    @Column(name= "last_name", length = 50, nullable = false, unique = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Client () {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
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

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
