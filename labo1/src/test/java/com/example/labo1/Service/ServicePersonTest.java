package com.example.labo1.Service;

import com.example.labo1.Model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicePersonTest {

    @Test
    void testUpdatePersonName() {
        Person p = new Person();
        p.setName("Old");
        p.setName("New");
        assertEquals("New", p.getName());
    }

    @Test
    void testUpdatePersonLastName() {
        Person p = new Person();
        p.setLastName("OldLast");
        p.setLastName("NewLast");
        assertEquals("NewLast", p.getLastName());
    }

    @Test
    void testUpdatePersonEmail() {
        Person p = new Person();
        p.setEmail("old@example.com");
        p.setEmail("new@example.com");
        assertEquals("new@example.com", p.getEmail());
    }

    @Test
    void testUpdatePersonGender() {
        Person p = new Person();
        p.setGender("M");
        p.setGender("F");
        assertEquals("F", p.getGender());
    }
}
