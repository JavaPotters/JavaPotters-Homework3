package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}

