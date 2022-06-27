package com.ironhacker.JavaPottersHomework3.repository;

import com.ironhacker.JavaPottersHomework3.enums.IndustryEnum;
import com.ironhacker.JavaPottersHomework3.enums.ProductEnum;
import com.ironhacker.JavaPottersHomework3.enums.StatusEnum;
import com.ironhacker.JavaPottersHomework3.models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ActiveProfiles("test")
class LeadRepositoryTest {

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SalesRepRepository salesRepRepository;

    private Lead lead1, lead2;
    private Contact contact1, contact2;
    private Opportunity opportunity1, opportunity2;
    private Account account1, account2;
    private SalesRep salesRep1, salesRep2;

    @BeforeEach
    void setUp() {
        salesRep1 = new SalesRep("Laura");
        contact1 = new Contact("Carlos",  660142356, "carlos@email.com", "Desatranques Jaen");
        account1 = new Account("Desatranques Jaen", IndustryEnum.OTHER, 50, "Jaen", "Spain");
        opportunity1 = new Opportunity(ProductEnum.BOX, 20, contact1, StatusEnum.OPEN, salesRep1, account1);
        lead1 = new Lead("Carlos",  660142356, "carlos@email.com", "Desatranques Jaen", salesRep1);

        salesRep2 = new SalesRep("Ana");
        contact2 = new Contact("Mike", 634477579, "mike@email.com", "Tiempost");
        account2 = new Account("Tiempost", IndustryEnum.OTHER, 205, "Montevideo", "Uruguay");
        opportunity2 = new Opportunity(ProductEnum.FLATBED, 15, contact2, StatusEnum.OPEN, salesRep2, account2);
        lead2 = new Lead("Mike", 634477579, "mike@email.com", "Tiempost", salesRep2);

        salesRepRepository.saveAll(List.of(salesRep1, salesRep2));
        leadRepository.saveAll(List.of(lead1, lead2));
        contactRepository.saveAll(List.of(contact1, contact2));
        accountRepository.saveAll(List.of(account1,account2));
        opportunityRepository.saveAll(List.of(opportunity1,opportunity2));
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
        accountRepository.deleteAll();
        contactRepository.deleteAll();
        leadRepository.deleteAll();
        salesRepRepository.deleteAll();
    }

    @Test
    void findBySalesRep() {
        List<Lead> leadList1 = leadRepository.findBySalesRep(salesRep1);
        assertEquals(1, leadList1.size());
        assertEquals("Carlos", leadList1.get(0).getName());
        List<Lead> leadList2 = leadRepository.findBySalesRep(salesRep2);
        assertEquals(1, leadList2.size());
        assertEquals("Mike", leadList2.get(0).getName());
    }
}