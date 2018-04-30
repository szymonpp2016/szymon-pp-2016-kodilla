package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Map;

public interface BookStatistics {
    int averagePublicationYear(Map<BookSignature, BookLibraryB> books);
    int medianPublicationYear(Map<BookSignature, BookLibraryB> books);
}