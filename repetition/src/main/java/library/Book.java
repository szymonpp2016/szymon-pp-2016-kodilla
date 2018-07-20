package com.kodilla.testing.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
public class Book {

	@Getter
	@Setter
	String title;
	String author;
	int publicationYear;
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	   @Override
	    public String toString() {
	            return "Book{" +
	                "title='" + title + '\'' +
	                ", author='" + author + '\'' +
	                ", publicationYear=" + publicationYear +
	                '}';
	    }

}
