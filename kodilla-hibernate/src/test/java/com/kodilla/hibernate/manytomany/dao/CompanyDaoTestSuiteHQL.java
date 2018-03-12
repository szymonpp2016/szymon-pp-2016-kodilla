package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.CompanyHQL;
import com.kodilla.hibernate.manytomany.EmployeeHQL;
import static  org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyDaoTestSuiteHQL {
    @Autowired
    CompanyDaoHQL companyDao;
    @Autowired
    EmployeeDaoHQL employeeDao;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Kodilla module 13.4:  begin"); }
    @AfterClass
    public static void afterClass() {
        System.out.println("\n Test  module 13.4: end \n");
    }
    @Before
    public void before() {
        System.out.println("\n Preparing to execute test `Język HQL i Named Queries` : \n " );
    }
    @After
    public void after() {
        System.out.println("\n Test 'Język HQL i Named Queries': end  " );
    }


    @Test
    public void t1retrieveCompanyNameByTreeLetters(){

        //Given
        CompanyHQL softwareMachine = new CompanyHQL("Software Machine");
        CompanyHQL dataMaesters = new CompanyHQL("Data Maesters");
        CompanyHQL greyMatter = new CompanyHQL("Grey Matter");

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        List<CompanyHQL> CompanyList = companyDao.retrieveCompanyNameByTreeLetters("sof");

        //Then
         assertEquals(1,CompanyList.size() );

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
             companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void t2retrieveWorkerByLastName(){

        //Given
        EmployeeHQL johnSmith = new EmployeeHQL("John", "Smith");
        EmployeeHQL stephanieClarckson = new EmployeeHQL("Stephanie", "Clarckson");
        EmployeeHQL lindaKovalsky = new EmployeeHQL("Linda", "Kovalsky");

        //When
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();

        List<EmployeeHQL> EmployeeList = employeeDao.retrieveWorkerByLastName("Smith");

        //Then
         assertNotEquals(1, EmployeeList.size());

        //CleanUp
        try {
            companyDao.delete(johnSmithId);
            companyDao.delete(stephanieClarcksonId);
            companyDao.delete(lindaKovalskyId);
        } catch (Exception e) {
            //    //do nothing
        }
    }
}