package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
}
