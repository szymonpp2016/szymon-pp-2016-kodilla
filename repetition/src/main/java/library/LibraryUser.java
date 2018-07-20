package com.kodilla.testing.library;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
public class LibraryUser {

	
	
	 @Getter
	 @Setter
	    String firstname;
	    String lastname;
	    String peselId;
	
	public LibraryUser() {
		// TODO Auto-generated constructor stub
	}
	
	   @Override
	    public String toString() {
	        return "LibraryUser{" +
	                "firstname='" + firstname + '\'' +
	                ", lastname='" + lastname + '\'' +
	                ", peselId='" + peselId + '\'' +
	                '}';
	    }
}
