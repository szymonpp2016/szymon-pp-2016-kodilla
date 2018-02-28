package com.kodilla.spring.calculator;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    private static int testCounter = 0;
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Spring module 10.2:  begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Spring module 10.2: end");
    }
    @Before
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #"+ testCounter);
    }
    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        Double val = calculator.add(6, 2);
        //Then
        assertEquals(8, val, 0);
    }
    @Test
    public void testSub() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        Double val = calculator.sub(6, 2);
        //Then
        assertEquals(4, val, 0);
    }

    @Test
    public void testMulti() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        Double val = calculator.multi(6, 2);
        //Then
        assertEquals(12, val, 0);
    }
    @Test
    public void testDiv() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        Double val = calculator.div(6, 2);
        //Then
        assertEquals(3, val, 0);
    }
}

