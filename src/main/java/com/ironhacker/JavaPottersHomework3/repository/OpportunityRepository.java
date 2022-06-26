package com.ironhacker.JavaPottersHomework3.repository;


import com.ironhacker.JavaPottersHomework3.enums.ProductEnum;
import com.ironhacker.JavaPottersHomework3.enums.StatusEnum;
import com.ironhacker.JavaPottersHomework3.models.Lead;
import com.ironhacker.JavaPottersHomework3.models.Opportunity;
import com.ironhacker.JavaPottersHomework3.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    @Query(value = "SELECT s.name, COUNT(o.id) FROM opportunity o " +
            "JOIN sales_rep s ON s.id = o.sales_rep_id " +
            "GROUP BY sales_rep_id", nativeQuery = true)
    List<Object[]> findBySalesRepAssociate();

    @Query("SELECT productEnum, COUNT(id) FROM Opportunity o GROUP BY productEnum")
    List<Object[]> findByProductEnum();

    @Query(value = "SELECT a.country, COUNT(o.id) FROM opportunity o " +
            "JOIN account a ON o.account_id = a.id " +
            "GROUP BY a.country", nativeQuery = true)
    List<Object[]> findByCountry();

    @Query(value = "SELECT a.city, COUNT(o.id) FROM opportunity o " +
            "JOIN account a ON o.account_id = a.id " +
            "GROUP BY a.city", nativeQuery = true)
    List<Object[]> findByCity();

    @Query(value = "SELECT a.industry_enum, COUNT(o.id) FROM opportunity o " +
            "JOIN account a ON o.account_id = a.id " +
            "GROUP BY a.industry_enum", nativeQuery = true)
    List<Object[]> findByIndustryEnum();

    @Query("SELECT productEnum, COUNT(id) FROM Opportunity WHERE statusEnum LIKE :status " +
            "GROUP BY productEnum")
    List<Object[]> findByProductEnumAndStatus(@Param("status")StatusEnum statusEnum);

    @Query("SELECT AVG(quantity) FROM Opportunity")
    double findQuantityAverage();

    @Query("SELECT MAX(quantity) FROM Opportunity")
    int findQuantityMax();

    @Query("SELECT MIN(quantity) FROM Opportunity")
    int findQuantityMin();

}
