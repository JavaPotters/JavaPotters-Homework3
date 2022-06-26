package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.models.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {
    @Query(value = "SELECT o.status_enum, COUNT(s.id) FROM sales_rep s " +
            "JOIN opportunity o ON o.sales_rep_id = s.id " +
            "WHERE o.status_enum = 'CLOSED_WON'", nativeQuery = true)
    List<Object[]> findByStatusCloseWon();

    @Query(value = "SELECT o.status_enum, COUNT(s.id) FROM sales_rep s " +
            "JOIN opportunity o ON o.sales_rep_id = s.id " +
            "WHERE o.status_enum = 'CLOSED_LOST'", nativeQuery = true)
    List<Object[]> findByStatusCloseLost();

    @Query(value = "SELECT o.status_enum, COUNT(s.id) FROM sales_rep s " +
            "JOIN opportunity o ON o.sales_rep_id = s.id " +
            "WHERE o.status_enum = 'OPEN'", nativeQuery = true)
    List<Object[]> findByStatusOpen();
}
