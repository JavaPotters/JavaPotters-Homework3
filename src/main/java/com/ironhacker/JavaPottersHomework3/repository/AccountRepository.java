package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.enums.StatusEnum;
import com.ironhacker.JavaPottersHomework3.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT a.country, COUNT(o.id) FROM opportunity o " +
            "JOIN account a ON a.id = o.account_id " +
            "GROUP BY a.country", nativeQuery = true)
    List<Object[]> findByCountry();

    @Query(value = "SELECT a.country, COUNT(o.id) FROM opportunity o " +
            "JOIN account a ON a.id = o.account_id " +
            "WHERE o.status_enum LIKE :status " +
            "GROUP BY a.country", nativeQuery = true)
    List<Object[]> findByCountryAndStatus(@Param("status") String statusEnum);

    @Query(value = "SELECT a.city, COUNT(o.id) FROM opportunity o " +
            "JOIN account a ON a.id = o.account_id " +
            "WHERE o.status_enum LIKE :status " +
            "GROUP BY a.city", nativeQuery = true)
    List<Object[]> findByCityAndStatus(@Param("status") String statusEnum);

    @Query(value = "SELECT a.industry_enum, COUNT(o.id) FROM opportunity o " +
            "JOIN account a ON a.id = o.account_id " +
            "WHERE o.status_enum LIKE :status " +
            "GROUP BY a.industry_enum", nativeQuery = true)
    List<Object[]> findByIndustryAndStatus(@Param("status") String statusEnum);

    @Query("SELECT AVG(employeeAccount) FROM Account")
    double findEmployeeAverage();

    @Query("SELECT MAX(employeeAccount) FROM Account")
    int findEmployeeMax();

    @Query("SELECT MIN(employeeAccount) FROM Account")
    int findEmployeeMin();

}