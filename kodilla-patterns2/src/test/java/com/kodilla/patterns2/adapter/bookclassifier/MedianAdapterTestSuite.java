package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookLibraryA;
import org.junit.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeClass() {
    System.out.println("Test Kodilla module 20.5 Adapter:  begin"); }
    @AfterClass
    public static void afterClass() {
        System.out.println("\n Test  module 20.5: end \n");
    }
    @Before

    public void before() {
        testCounter++;
        System.out.println("\nPreparing to execute test `Library converter' #:"+ testCounter+"." );
    }
    @After
    public void after() {
        System.out.println("End Test `Library converter'  #"+ testCounter+".");
    }

    @Test
    public void testPublicationYearAvargeOddBooksNumber() {

        // Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<BookLibraryA> bookOfTypeA = new HashSet<>();
        bookOfTypeA.add(new BookLibraryA("Author 1", "Title 1", 2010, "Signature 1"));
        bookOfTypeA.add(new BookLibraryA("Author 2", "Title 2", 2015, "Signature 2"));
        bookOfTypeA.add(new BookLibraryA("Author 3", "Title 3", 2000, "Signature 3"));
        bookOfTypeA.add(new BookLibraryA("Author 4", "Title 4", 1985, "Signature 4"));
        bookOfTypeA.add(new BookLibraryA("Author 5", "Title 5", 1990, "Signature 5"));

        // When
        int avarge =medianAdapter.averagePublicationYear(bookOfTypeA);

        // Then
        assertEquals(2000, avarge);
    }

    @Test
    public void testPublicationYearMedianOddBooksNumber() {

        // Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<BookLibraryA> bookOfTypeA2 = new HashSet<>();
        bookOfTypeA2.add(new BookLibraryA("Author 1", "Title 1", 2010, "Signature 1"));
        bookOfTypeA2.add(new BookLibraryA("Author 2", "Title 2", 2005, "Signature 2"));
        bookOfTypeA2.add(new BookLibraryA("Author 3", "Title 3", 2000, "Signature 3"));
        bookOfTypeA2.add(new BookLibraryA("Author 4", "Title 4", 1995, "Signature 4"));
        bookOfTypeA2.add(new BookLibraryA("Author 5", "Title 5", 1999, "Signature 5"));

        // When
        int median =medianAdapter.publicationYearMedian(bookOfTypeA2);

        // Then
        assertEquals(2000, median);
    }
}
