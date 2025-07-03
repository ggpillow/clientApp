package com.example.clientapp.model;

import jakarta.persistence.*;

@Entity
@Table(name="contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "phone", length = 30, nullable = false, unique = true)
    private String phone;

    @Column(name= "email", length = 50, nullable = false, unique = true)
    private String email;

    //Пустой конструктор для JPA (создание объектов при загрузке из БД)
    public Contact() {

    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
