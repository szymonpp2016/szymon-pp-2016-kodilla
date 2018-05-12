package com.kodilla.stream.lambda;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.beautifier.PoemBeautifier;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        calculating_lambda();
        calculating_references();
        streamTransformationTeory();
        modul71PoemButifier();
        modul73ListVersion();

        //Zadanie modul 7.3
        Forum forum = new Forum();
        System.out.println("\n Stream filtering - immutable  user sex - M , post number - more then 0, younger then 20");

       Map<Integer, ForumUser> theResultUserList = forum.getTheUserList().stream()
                .filter(forumUser -> forumUser.getBirthDate().isAfter(LocalDate.of(2001,01,01) ) ) // alternatywnie getYear() > 2001)
                .filter(forumUser -> forumUser.getPostNumber() > 0)
                .filter(forumUser -> forumUser.getUserSex() == 'M')
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        System.out.println("\n the Map \n");
        System.out.println("# elements: " + theResultUserList.size());
        theResultUserList.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }



    public static void calculating_lambda() {

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("\n Calculating expressions with lambdas NEW \n");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
    }

    public static void calculating_references() {

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("\n Calculating expressions with method references \n");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
    }

    public static void modul71PoemButifier() {  // Zadanie modul 7.1

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("\n PoemBeautifier with lambda ");
        poemBeautifier.beautify(" poemat poemat poemat   ", " ABC", (txt_org, txt_beauty) -> txt_org + txt_beauty);
        poemBeautifier.beautify(" poemat 2 poemat 2 poemat 2  ", " LALALA", (txt_org, txt_beauty) -> txt_org + txt_org + txt_beauty + txt_beauty);

        System.out.println("\n PoemBeautifier with method references");
        poemBeautifier.beautify(" poemat poemat poemat   ", " ABC", poemBeautifier::addAToB);
        poemBeautifier.beautify(" poemat poemat poemat   ", " ABC", poemBeautifier::addAToAToBToB);
        poemBeautifier.beautify(" poemat poemat poemat   ", " ABC", poemBeautifier::bigLetter);
    }

    public static void  modul73ListVersion() {
        Forum forum = new Forum();
        System.out.println("\n Stream filtering - immutable  user sex - F , post number - more then 0, younger then 20");
        System.out.println("\n the list \n");
        forum.getTheUserList().stream()
                .filter(forumUser -> forumUser.getBirthDate().getYear() > 2001)
                .filter(forumUser -> forumUser.getPostNumber() > 0)
                .filter(forumUser -> forumUser.getUserSex() == 'F')
                .forEach(System.out::println);
    }

    public static void streamTransformationTeory() { //Teoria Modul 7.3 czesc a) -Operacje transformujące na Stream

               System.out.println("\n Operacje transformujące na Stream ");
        People.getList().stream()
                .map(s -> s.toUpperCase())  //alternatywnie referencyjnie .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println); //alternatywnie lambda .forEach(s -> System.out.println(s));

        //teoria Modul 7.3 czesc B -Stream na kolekcjach z dowolnymi obiektami
        System.out.println("\n Stream na kolekcjach z dowolnymi obiektami ");
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        //Kolektor Operacje terminalne - kolektory - Collectors.toList()
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("\n Kolektor Operacje terminalne - kolektory - Collectors.toList() # elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        // Kolektor Collectors.toMap()
        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("\n Kolektor Collectors.toMap() # elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        //Kolektor Collectors.joining()
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n NEXT", "<<", ">>"));

        System.out.println("\n Kolektor Collectors.joining() ");
        System.out.println(theResultStringOfBooks);
    }
}



