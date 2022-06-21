package com.ironhacker.JavaPottersHomework3.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lead_table")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String name;
    protected long phoneNumber;
    protected String email;
    protected String companyName;

    public Lead() {
    }

    public Lead(String name, long phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return id == lead.id && phoneNumber == lead.phoneNumber && Objects.equals(name, lead.name) && Objects.equals(email, lead.email) && Objects.equals(companyName, lead.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email, companyName);
    }
}