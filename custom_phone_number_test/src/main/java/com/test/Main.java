package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.raw.PhoneNumber;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // --- SAVE ---
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Contact contact = new Contact(1L, new PhoneNumber("+12125551234"));
            session.persist(contact);

            session.getTransaction().commit();
            System.out.println("Saved contact with phone: " + contact.getPhone());
        }

        // --- LOAD ---
        try (Session session = sessionFactory.openSession()) {
            Contact contact = session.get(Contact.class, 1L);
            System.out.println("Loaded contact with phone: " + contact.getPhone());
        }

        // --- UPDATE ---
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Contact contact = session.get(Contact.class, 1L);
            contact.setPhone(new PhoneNumber("+441234567890"));

            session.getTransaction().commit();
            System.out.println("Updated phone to: " + contact.getPhone());
        }

        // --- VERIFY UPDATE ---
        try (Session session = sessionFactory.openSession()) {
            Contact contact = session.get(Contact.class, 1L);
            System.out.println("Final phone: " + contact.getPhone());
        }

        // --- TEST VALIDATION ---
        try {
            new PhoneNumber("not-a-phone");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation worked: " + e.getMessage());
        }

        sessionFactory.close();
    }
}