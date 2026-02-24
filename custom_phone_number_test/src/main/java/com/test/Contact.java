package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.type.raw.PhoneNumber;

@Entity
public class Contact {

    @Id
    private Long id;

    private PhoneNumber phoneNumber;

    public Contact() {}

    public Contact(Long id, PhoneNumber phone) {
        this.id = id;
        this.phoneNumber = phone;
    }

    public Long getId() { return id; }
    public PhoneNumber getPhone() { return phoneNumber; }
    public void setPhone(PhoneNumber phone) { this.phoneNumber = phone; }
}
