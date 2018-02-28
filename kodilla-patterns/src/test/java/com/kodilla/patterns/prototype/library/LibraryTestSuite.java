package com.kodilla.patterns.prototype.library;

import static org.junit.Assert.*;
import org.junit.*;
import java.time.LocalDate;

public class LibraryTestSuite {
    private Book books1;
    private Book books2;
    private Library library = new Library("Project number 1");
    private static int testCounter = 0;

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
        System.out.println(("Starting Prototype test   \n"));
    }

    @AfterClass
    public static void aftereClass() {
        System.out.println("\n End Prototype  test");
    }

    private   void bookPrepare(Library library)
    {
        Book books1 = new Book("ksiazka 1", "autor 1", LocalDate.of(2001,11,11));
        Book books2 = new Book("ksiazka 2", "autor 2", LocalDate.of(2002,11,11));
        this.books1=books1;
        this.books2=books2;
        library.addBooks(books1);
        library.addBooks(books2);
    }

    @Test
    public void shallowCopy() throws CloneNotSupportedException {
        //given
        //creating the books  and assigning the lists
        bookPrepare(library);

        //making a shallow copy of object board
        Library cloneLibrary;
        cloneLibrary = library.shallowCopy();
        cloneLibrary.setName("Project number 2");

        //When
        library.remBooks(books2);

        //Then
        System.out.println("Test orginal: \n"+library);
        System.out.println("Test shallowCopy : \n"+ cloneLibrary);
        assertEquals(1, library.getBooks().size());
        assertEquals(1, cloneLibrary.getBooks().size());
        assertEquals(cloneLibrary.getBooks(), library.getBooks());
    }

    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        //given
        //creating the books
        bookPrepare(library);

        //making a deep copy of object board
        Library deepClonedLibrary;
        deepClonedLibrary = library.deepCopy();
        deepClonedLibrary.setName("Project number 3");

        //When
        library.remBooks(books2);

        //Then
        System.out.println("Test orginal: \n"+library);
        System.out.println("Test deepCopy: \n"+deepClonedLibrary);
        assertEquals(1, library.getBooks().size());
        assertEquals(2, deepClonedLibrary.getBooks().size());
        assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}


