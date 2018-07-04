package com.stream.link.streamtest;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * @author Comp
 *
 */
public class StreamAdv {

	 
	String name;
	int age;

	@Override
	public String toString() {
		return name;
	}

	public StreamAdv(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	static List<StreamAdv> persons = Arrays.asList(
			new StreamAdv("Max", 18), 
			new StreamAdv("Peter", 23),
			new StreamAdv("Pamela", 23),
			new StreamAdv("David", 12));

	public static void main(String[] args) {

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		myList.stream()
		.filter(s -> s.contains("c"))
		.map(String::toUpperCase)
		.sorted()
		.forEach(System.out::println);

		System.out.println("IntStream");

		IntStream.range(10, 20)
		.mapToObj(s -> s + 1).filter(s -> s > 15)
		.map(s -> s.toString())
		.map(s -> "numer: " + s)
		.findFirst().ifPresent(System.out::println);

		List<StreamAdv> filtered = persons.stream()
				.filter(p -> p.age > 10)
				.collect(Collectors.toList());

		System.out.println(filtered);

		filtered.stream().filter(s -> s.name.matches("P(?s).*"))
		.findFirst()
		.ifPresent(System.out::println);

		Map<Integer, List<StreamAdv>> personsByAge = persons.stream()
				.collect(Collectors.groupingBy(p -> p.name.length()));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));

		System.out.println(averageAge);

		IntSummaryStatistics ageSummary =
				persons
				.stream()
				.collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);

		String phrase = persons
				.stream()
				.filter(p -> p.age >= 18)
				.map(p -> p.name)
				.collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

		System.out.println(phrase);

		Map<Integer, String> map = persons
				.stream()
				.collect(Collectors.toMap(
						p -> p.age,
						p -> p.name, (a,b) ->a+b ));

		System.out.println(map);







	}

	public StreamAdv() {
		// TODO Auto-generated constructor stub
	}

}
