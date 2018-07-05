package com.kodilla.stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.MathExpression;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalBeutifier;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
	public static void main(String[] args) {

		System.out.println("Welcome to module 7 - Stream");

		Processor processor = new Processor();
		Executor codeToExecute = () -> System.out.println("This is an example text from LAMBDA statment.\n");
		processor.execute(codeToExecute);

		Executor sayMathExpresion = () -> {
			System.out.println("Lambda math");
		};
		processor.execute(sayMathExpresion);

		// to samo bezpoœrednio do metody

		processor.execute(() -> System.out.println("\n Lambda math 3"));

		ExpressionExecutor expressionExecutor = new ExpressionExecutor();

		MathExpression add = (a, b) -> {
			System.out.println("to jest wynik");
			return a + b;
		};

		System.out.println("Calculating expressions with lambdas");
		expressionExecutor.executeExpression(10, 5, add);
		expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
		expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
		expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
		// MathExpression Sth = public void calculateExpresion(a,b) {a+b}

		System.out.println("Calculating expressions with method references");
		expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
		expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
		expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
		expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

		PoemBeautifier poemBeautifier = new PoemBeautifier();
		PoemDecorator decorate = (txt, decor) -> decor + txt + decor;

		String textOrg = "W metodzie main(String[] args) klasy StreamMain, utwórz obiekt klasy PoemBeautifier";

		System.out.println("PoemDecorator");
		poemBeautifier.beautify(textOrg, "ABC ", (txt, decor) -> decor + txt + decor);
		poemBeautifier.beautify(textOrg, "ABC ", (txt, decor) -> decor + txt.toUpperCase() + decor);
		poemBeautifier.beautify(textOrg, "ABC ", (txt, decor) -> decor + txt.toLowerCase() + decor);

		poemBeautifier.beautify(textOrg, "ABC ", FunctionalBeutifier::adABC);

		System.out.println("Stream 7.2");

		System.out.println("Using Stream to generate even numbers from 1 to 20");
		NumbersGenerator.generateEven(20);
		System.out.println("Using Stream to generate not even numbers from 1 to 20");
		NumbersGenerator.generateNotEven(20);

		System.out.println("Stream 7.3 LIST NAME");

		People.getList().stream().forEach(System.out::println);

		People.getList().stream().forEach(i -> {
			if (i != "Khloe fry")
				i = i;
			else
				i = "Khloe Fry";
			System.out.print(i + ",");
		});

		System.out.println();
		People.getList().stream().map(String::toUpperCase).filter(s -> s.length() > 11)
				.map(s -> s.substring(0, s.indexOf(' ') + 2) + ".").filter(s -> s.substring(0, 1).equals("D"))
				.forEach(System.out::println);

		System.out.println("Stream 7.3 BOOK");

		BookDirectory theBookDirectory = new BookDirectory();
		theBookDirectory.getList().stream().filter(book -> book.getYearOfPublication() > 2005)
				.forEach(System.out::println);

		System.out.println("Stream 7.3 BOOK to LISt");

		BookDirectory theBookDirectory1 = new BookDirectory();
		List<Book> theResultListOfBooks = theBookDirectory1.getList().stream()
				.filter(book -> book.getYearOfPublication() > 2005).collect(Collectors.toList());

		System.out.println("# elements: " + theResultListOfBooks.size());
		theResultListOfBooks.stream().forEach(System.out::println);

		System.out.println("Stream 7.3 BOOK to LIST with SIGNATURA");

		BookDirectory theBookDirectory11 = new BookDirectory();

		Map<Integer, Book> theResultMapOfBooks = Collections.emptyMap();
		try {
			  theBookDirectory11.getList().stream()
					.filter(book -> book.getYearOfPublication() > 2005)
					.collect(Collectors.toMap(Book::getYearOfPublication, book -> book));
		} catch (Exception e) {
			System.out.println("error");
		}

		System.out.println("# elements: " + theResultMapOfBooks.size());
		theResultMapOfBooks.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue())
				.forEach(System.out::println);

		System.out.println("Stream 7.3 BOOK Joining");

		BookDirectory theBookDirectory111 = new BookDirectory();
		String theResultStringOfBooks = theBookDirectory111.getList().stream()
				.filter(book -> book.getYearOfPublication() > 2005).map(Book::toString).map(i -> ">>" + i + "<<")
				.collect(Collectors.joining(",\n", "<<", ">>"));

		System.out.println(theResultStringOfBooks);
		
		System.out.println("Stream 7.3 BOOK Forum");
		
		Forum forum = new Forum(); 
		
		Map<Integer, Object> forumMap = forum.getTheUserList().stream()
                .filter(forumUser -> forumUser.getUserSex()=='M')
                .filter(forumUser -> forumUser.getBirthDate().getYear()>1997)
                .filter(forumUser -> forumUser.getPostNumber()>1)
                 .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));
		
		System.out.println("# elements: " + forumMap.size());
		forumMap.entrySet().stream().map(entry -> entry.getKey() + ": " + entry.getValue())
				.forEach(System.out::println);
	}

}
