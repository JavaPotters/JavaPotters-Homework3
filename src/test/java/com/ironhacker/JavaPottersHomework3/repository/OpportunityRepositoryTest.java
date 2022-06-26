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
class OpportunityRepositoryTest {

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
    void findBySalesRepAssociate() {
        List<Object[]> resultList = opportunityRepository.findBySalesRepAssociate();
        assertEquals(2, resultList.size());
        assertEquals("Laura", resultList.get(0)[0]);
        assertEquals("Ana", resultList.get(1)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(0)[1]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(1)[1]);
    }

    @Test
    void findByProductEnum() {
        List<Object[]> resultList = opportunityRepository.findByProductEnum();
        assertEquals(2, resultList.size());
        assertEquals(ProductEnum.BOX, resultList.get(0)[0]);
        assertEquals(ProductEnum.FLATBED, resultList.get(1)[0]);
        assertEquals(1L, resultList.get(0)[1]);
        assertEquals(1L, resultList.get(1)[1]);
    }

    @Test
    void findByCountry() {
        List<Object[]> resultList = opportunityRepository.findByCountry();
        assertEquals(2, resultList.size());
        assertEquals("Spain", resultList.get(0)[0]);
        assertEquals("Uruguay", resultList.get(1)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(0)[1]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(1)[1]);
    }

    @Test
    void findByCity() {
        List<Object[]> resultList = opportunityRepository.findByCity();
        assertEquals(2, resultList.size());
        assertEquals("Jaen", resultList.get(0)[0]);
        assertEquals("Montevideo", resultList.get(1)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(0)[1]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(1)[1]);
    }

    @Test
    void findByIndustryEnum() {
        List<Object[]> resultList = opportunityRepository.findByIndustryEnum();
        assertEquals(1, resultList.size());
        assertEquals("OTHER", resultList.get(0)[0]);
        assertEquals(BigInteger.valueOf(2L), resultList.get(0)[1]);
    }

    @Test
    void findByProductEnumAndStatus() {
        List<Object[]> resultList1 = opportunityRepository.findByProductEnumAndStatus(StatusEnum.OPEN);
        assertEquals(1, resultList1.size());
        assertEquals(ProductEnum.FLATBED, resultList1.get(0)[0]);
        assertEquals(1L, resultList1.get(0)[1]);

        List<Object[]> resultList2 = opportunityRepository.findByProductEnumAndStatus(StatusEnum.CLOSED_WON);
        assertEquals(1, resultList2.size());
        assertEquals(ProductEnum.BOX, resultList2.get(0)[0]);
        assertEquals(1L, resultList2.get(0)[1]);

        List<Object[]> resultList3 = opportunityRepository.findByProductEnumAndStatus(StatusEnum.CLOSED_LOST);
        assertEquals(0, resultList3.size());
    }

    @Test
    void findQuantityAverage() {
        double result = opportunityRepository.findQuantityAverage();
        assertEquals(17.5, result);
    }

    @Test
    void findQuantityMax() {
        int result = opportunityRepository.findQuantityMax();
        assertEquals(20, result);
    }

    @Test
    void findQuantityMin() {
        int result = opportunityRepository.findQuantityMin();
        assertEquals(15, result);
    }

}