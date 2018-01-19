package com.kodilla.testing.library;

import java.util.*;



public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }
    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<String> userNames() {
        return Collections.emptyList();
    }
public List<String> BookInHand() {
        return Collections.emptyList();
    }

    public List<String> listBooksInHandsOf(LibraryUser libraryUser) {

        /*BookInhHand = libraryUser.booksNames().size();
     ;

        if (userCount == 0) {
            averagePostPerUser = 0;
            averageCommentsPerPost = 0;
            averageCommentsPerUser = 0;

        } */
    return Collections.emptyList();
    }
}