package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookLibraryB;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    private BookStatistics statistics = new Statistics();

    @Override
    public int averagePublicationYear(Map<BookSignature, BookLibraryB> booksOfTypeB) {
        return statistics.averagePublicationYear(booksOfTypeB);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, BookLibraryB> booksOfTypeB) {
        return statistics.medianPublicationYear(booksOfTypeB);
    }
}
