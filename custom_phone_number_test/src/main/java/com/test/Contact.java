package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Auditable;
import org.hibernate.type.raw.PhoneNumber;

import java.time.LocalDateTime;

@Entity
@Auditable
public class Contact {

    @Id
    private Long id;

    private PhoneNumber phoneNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Contact() {}

    public Contact(Long id, PhoneNumber phone) {
        this.id = id;
        this.phoneNumber = phone;
    }

    public Long getId() { return id; }
    public PhoneNumber getPhone() { return phoneNumber; }
    public void setPhone(PhoneNumber phone) { this.phoneNumber = phone; }

    @Override
    public String toString() {
        return String.format("phone number: %s - createdAt: %s - updatedAt: %s", phoneNumber, createdAt, updatedAt);
    }
}
