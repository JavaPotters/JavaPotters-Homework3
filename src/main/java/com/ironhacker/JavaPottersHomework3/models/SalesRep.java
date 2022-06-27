package com.ironhacker.JavaPottersHomework3.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "salesRep")
    private List<Lead> leadList;

    @OneToMany(mappedBy = "salesRepAssociate")
    private List<Opportunity> opportunityList;

    public SalesRep() {
    }

    public SalesRep(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesRep salesRep = (SalesRep) o;
        return Objects.equals(name, salesRep.name) && Objects.equals(leadList, salesRep.leadList) && Objects.equals(opportunityList, salesRep.opportunityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, leadList, opportunityList);
    }
}
