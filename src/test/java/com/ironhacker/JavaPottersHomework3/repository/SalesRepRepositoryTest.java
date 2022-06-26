package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.enums.IndustryEnum;
import com.ironhacker.JavaPottersHomework3.enums.ProductEnum;
import com.ironhacker.JavaPottersHomework3.enums.StatusEnum;
import com.ironhacker.JavaPottersHomework3.models.Account;
import com.ironhacker.JavaPottersHomework3.models.Contact;
import com.ironhacker.JavaPottersHomework3.models.Opportunity;
import com.ironhacker.JavaPottersHomework3.models.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalesRepRepositoryTest {

    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SalesRepRepository salesRepRepository;
    private Contact contact1, contact2;
    private Opportunity opportunity1, opportunity2;
    private Account account1, account2;
    private SalesRep salesRep1, salesRep2;

    @BeforeEach
    void setUp() {
        salesRep1 = new SalesRep("Laura");
        contact1 = new Contact("Carlos",  660142356, "carlos@email.com", "Desatranques Jaen");
        account1 = new Account("Desatranques Jaen", IndustryEnum.OTHER, 50, "Jaen", "Spain");
        opportunity1 = new Opportunity(ProductEnum.BOX, 20, contact1, StatusEnum.CLOSED_WON, salesRep1, account1);

        salesRep2 = new SalesRep("Ana");
        contact2 = new Contact("Mike", 634477579, "mike@email.com", "Tiempost");
        account2 = new Account("Tiempost", IndustryEnum.OTHER, 205, "Montevideo", "Uruguay");
        opportunity2 = new Opportunity(ProductEnum.FLATBED, 15, contact2, StatusEnum.OPEN, salesRep2, account2);

        salesRepRepository.saveAll(List.of(salesRep1, salesRep2));
        contactRepository.saveAll(List.of(contact1, contact2));
        accountRepository.saveAll(List.of(account1,account2));
        opportunityRepository.saveAll(List.of(opportunity1,opportunity2));
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
        accountRepository.deleteAll();
        contactRepository.deleteAll();
        salesRepRepository.deleteAll();
    }

    @Test
    void findByStatusCloseWon() {
        List<Object[]> resultList = salesRepRepository.findByStatusCloseWon();
        assertEquals(1, resultList.size());
        assertEquals("CLOSED_WON", resultList.get(0)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(0)[1]);
    }

    @Test
    void findByStatusCloseLost() {
        List<Object[]> resultList = salesRepRepository.findByStatusCloseLost();
        assertEquals(1, resultList.size());
        assertEquals(null, resultList.get(0)[0]);
        assertEquals(BigInteger.valueOf(0L), resultList.get(0)[1]);
    }

    @Test
    void findByStatusOpen() {
        List<Object[]> resultList = salesRepRepository.findByStatusOpen();
        assertEquals(1, resultList.size());
        assertEquals("OPEN", resultList.get(0)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(0)[1]);
    }
}