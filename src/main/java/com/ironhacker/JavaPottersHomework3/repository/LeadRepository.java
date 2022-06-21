package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}
