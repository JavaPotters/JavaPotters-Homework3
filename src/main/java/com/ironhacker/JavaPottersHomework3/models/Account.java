package com.ironhacker.JavaPottersHomework3.models;

import com.ironhacker.JavaPottersHomework3.enums.IndustryEnum;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private IndustryEnum industryEnum;
    private int employeeAccount;
    private String city;
    private String country;
    /*private List<Contact> contactList;
    private List<Opportunity> opportunityList;*/
    //private String companyName;


    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public IndustryEnum getIndustryEnum() {
        return industryEnum;
    }

    public void setIndustryEnum(IndustryEnum industryEnum) {
        this.industryEnum = industryEnum;
    }

    public int getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(int employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    /*
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }*/
}