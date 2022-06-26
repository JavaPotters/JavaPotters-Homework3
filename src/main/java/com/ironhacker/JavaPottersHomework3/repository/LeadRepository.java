package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.models.Lead;
import com.ironhacker.JavaPottersHomework3.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    List<Lead> findBySalesRep(SalesRep salesRep);
}
