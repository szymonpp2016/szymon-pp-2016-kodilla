package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {
    private String name;
    private Set<Book> books = new HashSet<>();

    Library(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedlibrary = super.clone();
        clonedlibrary.books = new HashSet<>();

        clonedlibrary.books.addAll(books);
        return clonedlibrary;
    }

    private String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Book> getBooks() {
        return books;
    }
    public  void addBooks(Book book) {
        books.add(book);
     }
    public  void remBooks(Book book) {
        books.remove(book);
    }

    @Override
    public String toString() {

        return "Board  " + getName() + books;
    }
}