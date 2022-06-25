package com.ironhacker.JavaPottersHomework3.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contact extends Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "decisionMaker")
    private Opportunity opportunity;

    public Contact() {
    }


    public Contact(String name, int phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
