package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.CompanyHQL;
import com.kodilla.hibernate.manytomany.EmployeeHQL;
import com.kodilla.hibernate.manytomany.dao.CompanyDaoHQL;
import com.kodilla.hibernate.manytomany.dao.EmployeeDaoHQL;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeCompanyHQLServiceFacadeTest {

    @Autowired
    CompanyDaoHQL companyDao;
    @Autowired
    EmployeeDaoHQL employeeDao;

     public static void beforeClass() {
        System.out.println("Test Kodilla module 20.1 FACADE:  begin"); }
    @AfterClass
    public static void afterClass() {
        System.out.println("\n Test  module 20.1: end \n");
    }
    @Before
    public void before() {
        System.out.println("\n Preparing to execute test `Język HQL i Named Queries` with FACADE : \n " );
    }
    @After
    public void after() {
        System.out.println("\n Test 'Język HQL i Named Queries' with FACADE: end  " );
    }


    @Test
    public void t1RetrieveCompanyNameByPartOfName(){

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




        List<CompanyHQL> CompanyListWithOneExistPartOfName = companyDao.retrieveCompanyNameByPartOfName("Gr");
        List<CompanyHQL> CompanyListWithOFreeExistPartOfName = companyDao.retrieveCompanyNameByPartOfName("Ma");
        List<CompanyHQL> CompanyListWithNotExistPartOfName = companyDao.retrieveCompanyNameByPartOfName("Graa");
        List<CompanyHQL> CompanyListWithNullStringPartOfName = Collections.emptyList();
        //Then
        assertEquals(1,CompanyListWithOneExistPartOfName.size() );
        assertEquals(3,CompanyListWithOFreeExistPartOfName.size() );
        assertEquals(0,CompanyListWithNotExistPartOfName.size() );
        assertEquals(0,CompanyListWithNullStringPartOfName.size() );
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
    public void t2RetrieveWorkerByPartOfNameTest(){

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

        List<EmployeeHQL> EmployeeListWithOneExistPartOfName = employeeDao.retrieveWorkerByPartOfName("Sm");
        List<EmployeeHQL> EmployeeyListWithOFreeExistPartOfName = employeeDao.retrieveWorkerByPartOfName("k");
        List<EmployeeHQL> EmployeeListWithNotExistPartOfName = employeeDao.retrieveWorkerByPartOfName("Graa");
        List<EmployeeHQL> EmployeeListWithNullStringPartOfName = Collections.emptyList();
        //Then
        assertEquals(1,EmployeeListWithOneExistPartOfName.size() );
        assertEquals(2,EmployeeyListWithOFreeExistPartOfName.size() );
        assertEquals(0,EmployeeListWithNotExistPartOfName.size() );
        assertEquals(0,EmployeeListWithNullStringPartOfName.size() );


        //CleanUp
        try {
            employeeDao.delete(johnSmithId);
            employeeDao.delete(stephanieClarcksonId);
            employeeDao.delete(lindaKovalskyId);

        } catch (Exception e) {
            //    //do nothing
        }
    }
}

