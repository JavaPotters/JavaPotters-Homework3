package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    default void showLead(){
        System.out.println("List of leads: ");
        List<Lead> leadList = this.findAll();
        for(Lead lead: leadList){
            System.out.println(lead);
        }
    }


}
