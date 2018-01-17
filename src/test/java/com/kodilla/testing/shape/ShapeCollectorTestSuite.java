package com.kodilla.testing.shape;

import org.junit.*;

import com.kodilla.testing.shape.ShapeCollector;
import java.lang.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;
    private ShapeCollector shapeCollector = new ShapeCollector();

    @Before
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testAddFigure() {
        //Given
        Circle circle = new Circle("Circle", 5);

        //When
        shapeCollector.addFigure(circle);
        //Then
        System.out.println("Rezultat testu 1");
        Assert.assertEquals(circle, shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Circle circle = new Circle("Circle", 5);
        shapeCollector.addFigure(circle);

        //When
        boolean result = shapeCollector.removeFigure(circle);
        System.out.println("Rezultat testu 2");
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testGetFigure() {
        //Given

        Circle circle = new Circle("Circle", 5);
        Square square = new Square("Square", 5);
        Triangle traingle = new Triangle("Traingle", 5);

        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(traingle);

        //When
        Shape result1 = shapeCollector.getFigure(2);

        //Then
        System.out.println("Resultat testu 3");
        Assert.assertEquals(traingle, result1);
    }

}