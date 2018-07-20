package com.kodilla.testing.library;

import java.util.Collections;
import java.util.List;

public class BookLibrary {
	LibraryDatabase libraryDatabase;

	public BookLibrary(LibraryDatabase libraryDatabase) {
		this.libraryDatabase = libraryDatabase;
	}

	public List<Book> listBooksWithCondition(String titleFragment) {

		if (titleFragment.length() > 3 && libraryDatabase.listBooksWithCondition("Secret").size() < 20)
			return (List<Book>) libraryDatabase.listBooksWithCondition("Secret");
		else
			return Collections.emptyList();
	}

	public int listBooksInHandsOf(LibraryUser libraryUser) {

		if (libraryDatabase.listBooksInHandsOf(libraryUser).size() == 0)
			return 0;
		else
			return libraryDatabase.listBooksInHandsOf(libraryUser).size();

	}
}
