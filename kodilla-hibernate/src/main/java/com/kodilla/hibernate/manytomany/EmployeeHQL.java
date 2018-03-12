package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "EmployeeHQL.retrieveWorkerByLastName",
                query = "FROM EmployeeHQL WHERE workerLastName = :WORKERLASTNAME"
        )
})

@Entity
@Table(name = "EMPLOYEESHQL")
public class EmployeeHQL {
    private int id;
    private String workerFirstName;
    private String workerLastName;
    private List<CompanyHQL> companies = new ArrayList<>();

    public EmployeeHQL() {
    }

    public EmployeeHQL(String workerFirstName, String workerLastName) {
        this.workerFirstName = workerFirstName;
        this.workerLastName = workerLastName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "workerFirstName")
    public String getWorkerFirstName() {
        return workerFirstName;
    }

    @NotNull
    @Column(name = "workerLastName")
    public String getWorkerLastName() {
        return workerLastName;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setWorkerFirstName(String workerFirstName) {
        this.workerFirstName = workerFirstName;
    }
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "JOIN_COMPANY_EMPLOYEEHQL",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")})
    public List<CompanyHQL> getCompanies() {
        return companies;
    }

    public void setCompanies(List<CompanyHQL> companies) {
        this.companies = companies;
    }

    private void setWorkerLastName(String workerLastName) {
        this.workerLastName = workerLastName;



    }
}