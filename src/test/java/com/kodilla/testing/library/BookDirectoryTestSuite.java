package com.kodilla.testing.library;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    private static int testCounter = 0;

    @Before
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #"+ testCounter);
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


    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FourtyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());

    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());



    }
    @Test
    public void testListOfUserBooksNoBook(){
        //Given
        BookLibrary bookLibraryMock = mock(BookLibrary.class);
        LibraryUser libraryUseryMock = mock(LibraryUser.class);
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        List<Book> listOfBooks = new ArrayList<>();
        when(bookLibraryMock.listBooksInHandsOf(libraryUseryMock)).thenReturn(listOfBooks);

        //When
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        bookLibrary.listBooksInHandsOf(libraryUseryMock);

        //Then
        Assert.assertEquals(0, listOfBooks.size());
    }

    @Test
    public void testListOfUserBooksOneBook(){
        //Given
        BookLibrary bookLibraryMock = mock(BookLibrary.class);
        LibraryUser libraryUseryMock = mock(LibraryUser.class);
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Secrets of Alamo", "John Smith", 2008));
        when(bookLibraryMock.listBooksInHandsOf(libraryUseryMock)).thenReturn(listOfBooks);

        //When
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        bookLibrary.listBooksInHandsOf(libraryUseryMock);

        //Then
        Assert.assertEquals(1, listOfBooks.size());

    }

    @Test
    public void testListOfUserBooksFiveBooks(){
        //Given
        BookLibrary bookLibraryMock = mock(BookLibrary.class);
        LibraryUser libraryUseryMock = mock(LibraryUser.class);
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        List<Book> listOfBooks = new ArrayList<>();
        for(int i=0;i<5;i++){
            listOfBooks.add(new Book("Secrets of Alamo", "John Smith", 2008));
        }
        when(bookLibraryMock.listBooksInHandsOf(libraryUseryMock)).thenReturn(listOfBooks);

        //When
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        bookLibrary.listBooksInHandsOf(libraryUseryMock);

        //Then
        Assert.assertEquals(5, listOfBooks.size());
    }
}