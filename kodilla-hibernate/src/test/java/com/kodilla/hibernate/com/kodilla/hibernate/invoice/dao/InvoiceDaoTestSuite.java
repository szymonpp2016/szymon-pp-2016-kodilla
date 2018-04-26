package com.kodilla.hibernate.com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.invoice.dao.InvoiceDao;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class InvoiceDaoTestSuite {
  /*  @Autowired
    private InvoiceDao invoiceDao;

    private static final String DESCRIPTION = "Test:LearnHibernate";
    private static final String LISTNAME = "Tabela_nr_1";


    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Kodilla module 13.3:  begin"); }
    @AfterClass
    public static void afterClass() {
        System.out.println("\n Test  module 13.3: end \n");
    }
    @Before
    public void before() {
        System.out.println("\n Preparing to execute test `Tworzymy relacje pomiędzy encjami` : \n " );
    }
    @After
    public void after() {
        System.out.println("\n Test 'Tworzymy relacje pomiędzy encjami': end  " );
    }


    @Test
    public void testNamedQueries() {
        //Given
        Product product1 = new Product("Test:1");
        Product product2 = new Product("Test:2");
        Product product3 = new Product("Test:3");

        Item item1 = new Item(new BigDecimal(130), 100, new BigDecimal(13000));
        Item item2 = new Item(new BigDecimal(230), 100, new BigDecimal(23000));
        Item item3 = new Item(new BigDecimal(330), 100, new BigDecimal(33000));

        Invoice invoice1 = new Invoice("123");

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice1);

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice1.getItems().add(item3);



        //When
        invoiceDao.save(invoice1);
        int id = invoice1.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
         //invoiceDao.delete(id);

    } */


}

