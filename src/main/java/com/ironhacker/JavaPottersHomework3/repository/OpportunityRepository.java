package com.ironhacker.JavaPottersHomework3.repository;


import com.ironhacker.JavaPottersHomework3.enums.ProductEnum;
import com.ironhacker.JavaPottersHomework3.models.Lead;
import com.ironhacker.JavaPottersHomework3.models.Opportunity;
import com.ironhacker.JavaPottersHomework3.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    List<Lead> findBySalesRepAssociate(SalesRep salesRepAssociate);

    List<ProductEnum> findByProductEnum(ProductEnum productEnum);




}
