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
class AccountRepositoryTest {

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
    void findByCountry() {
        List<Object[]> resultList = accountRepository.findByCountry();
        assertEquals(2, resultList.size());
        assertEquals("Spain", resultList.get(0)[0]);
        assertEquals("Uruguay", resultList.get(1)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(0)[1]);
        assertEquals(BigInteger.valueOf(1L), resultList.get(1)[1]);
    }

    @Test
    void findByCountryAndStatus() {
        List<Object[]> resultList1 = accountRepository.findByCountryAndStatus("OPEN");
        assertEquals(1, resultList1.size());
        assertEquals("Uruguay", resultList1.get(0)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList1.get(0)[1]);

        List<Object[]> resultList2 = accountRepository.findByCountryAndStatus("CLOSED_WON");
        assertEquals(1, resultList2.size());
        assertEquals("Spain", resultList2.get(0)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList2.get(0)[1]);

        List<Object[]> resultList3 = accountRepository.findByCountryAndStatus("CLOSED_LOST");
        assertEquals(0, resultList3.size());
    }

    @Test
    void findByCityAndStatus() {
        List<Object[]> resultList1 = accountRepository.findByCityAndStatus("OPEN");
        assertEquals(1, resultList1.size());
        assertEquals("Montevideo", resultList1.get(0)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList1.get(0)[1]);

        List<Object[]> resultList2 = accountRepository.findByCityAndStatus("CLOSED_WON");
        assertEquals(1, resultList2.size());
        assertEquals("Jaen", resultList2.get(0)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList2.get(0)[1]);

        List<Object[]> resultList3 = accountRepository.findByCityAndStatus("CLOSED_LOST");
        assertEquals(0, resultList3.size());
    }

    @Test
    void findByIndustryAndStatus() {
        List<Object[]> resultList1 = accountRepository.findByIndustryAndStatus("OPEN");
        assertEquals(1, resultList1.size());
        assertEquals("OTHER", resultList1.get(0)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList1.get(0)[1]);

        List<Object[]> resultList2 = accountRepository.findByIndustryAndStatus("CLOSED_WON");
        assertEquals(1, resultList2.size());
        assertEquals("OTHER", resultList2.get(0)[0]);
        assertEquals(BigInteger.valueOf(1L), resultList2.get(0)[1]);

        List<Object[]> resultList3 = accountRepository.findByIndustryAndStatus("CLOSED_LOST");
        assertEquals(0, resultList3.size());
    }

    @Test
    void findEmployeeAverage() {
        double result = accountRepository.findEmployeeAverage();
        assertEquals(127.5, result);
    }

    @Test
    void findEmployeeMax() {
        int result = accountRepository.findEmployeeMax();
        assertEquals(205, result);
    }

    @Test
    void findEmployeeMin() {
        int result = accountRepository.findEmployeeMin();
        assertEquals(50, result);
    }
}