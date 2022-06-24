package com.ironhacker.JavaPottersHomework3.repository;


import com.ironhacker.JavaPottersHomework3.models.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {

    default void showOpportunies(){
        System.out.println("List of opportunities: ");
        List<Opportunity> opportunityList = this.findAll();
        for(Opportunity opportunity: opportunityList){
            System.out.println(opportunity);
        }
    }


}
