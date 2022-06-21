package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}