package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.BookLibraryA;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookLibraryB;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MedianAdapter extends MedianAdaptee implements Classifier {


    @Override
    public int publicationYearMedian(Set<BookLibraryA> theBookLibraryASet) {
        Map<BookSignature, BookLibraryB> mapOfBooks = new HashMap<>();

        for (BookLibraryA books : theBookLibraryASet) {
            mapOfBooks.put(new BookSignature(books.getSignature()),
                    new BookLibraryB(books.getAuthor(), books.getTitle(), books.getPublicationYear()));
        }
        return medianPublicationYear(mapOfBooks);
    }


    public int averagePublicationYear(Set<BookLibraryA> theBookLibraryASet) {
        Map<BookSignature, BookLibraryB> mapOfBooks = new HashMap<>();

        for (BookLibraryA books : theBookLibraryASet) {
            mapOfBooks.put(new BookSignature(books.getSignature()),
                    new BookLibraryB(books.getAuthor(), books.getTitle(), books.getPublicationYear()));
        }
        return averagePublicationYear(mapOfBooks);
    }

/*
    public int publicationYearMedian1(Set<BookLibraryA> theBookLibraryASet) {
        Map<BookSignature, BookLibraryB> mapOfBooks = new HashMap<>();

        theBookLibraryASet.forEach(i -> {
            mapOfBooks.put(new BookSignature(theBookLibraryASet.iterator().next().getSignature()), new BookLibraryB(theBookLibraryASet.iterator().next().getAuthor(), theBookLibraryASet.iterator().next().getTitle(), theBookLibraryASet.iterator().next().getPublicationYear())); theBookLibraryASet.remove(theBookLibraryASet.iterator().next().getSignature());
            System.out.println(mapOfBooks.entrySet().iterator().next().getValue().getYearOfPublication());
        });
        return medianAdaptee.medianPublicationYear(mapOfBooks);
    }


    public int averagePublicationYear1(Set<BookLibraryA> theBookLibraryASet) {
        Map<BookSignature, BookLibraryB> mapOfBooks = new HashMap<>();

        IntStream.range(0, theBookLibraryASet.size()).forEach(i -> {
            mapOfBooks.put(new BookSignature(theBookLibraryASet.iterator().next().getSignature()), new BookLibraryB(theBookLibraryASet.iterator().next().getAuthor(), theBookLibraryASet.iterator().next().getTitle(), theBookLibraryASet.iterator().next().getPublicationYear()));
        });
        return statistics.averagePublicationYear(mapOfBooks);
    } */
}