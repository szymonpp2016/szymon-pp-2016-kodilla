package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "CompanyHQL.retrieveCompanyNameByTreeLetters",
        query = "SELECT * FROM COMPANIESHQL " +
                "WHERE SUBSTR(COMPANY_NAME, 1, 3) = :COMPANY_NAME",
        resultClass = CompanyHQL.class
)

@Entity
@Table(name = "COMPANIESHQL")
public class CompanyHQL {
    private int id;
    private String name;
    private List<EmployeeHQL> employees = new ArrayList<>();

    public CompanyHQL() {
    }

    public CompanyHQL(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
@ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<EmployeeHQL> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeHQL> employees) {
        this.employees = employees;
    }
}