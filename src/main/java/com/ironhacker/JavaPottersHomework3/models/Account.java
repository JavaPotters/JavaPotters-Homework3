package com.ironhacker.JavaPottersHomework3.models;

import com.ironhacker.JavaPottersHomework3.enums.IndustryEnum;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String companyName;
    @Enumerated(EnumType.STRING)
    private IndustryEnum industryEnum;
    private int employeeAccount;
    private String city;
    private String country;

    @OneToMany(mappedBy = "account")
    private List<Opportunity> opportunityList;



    public Account() {
    }

    public Account(String companyName, IndustryEnum industryEnum, int employeeAccount, String city, String country) {
        this.companyName = companyName;
        this.industryEnum = industryEnum;
        this.employeeAccount = employeeAccount;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return employeeAccount == account.employeeAccount && Objects.equals(companyName, account.companyName) && industryEnum == account.industryEnum && Objects.equals(city, account.city) && Objects.equals(country, account.country) && Objects.equals(opportunityList, account.opportunityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, industryEnum, employeeAccount, city, country, opportunityList);
    }
}