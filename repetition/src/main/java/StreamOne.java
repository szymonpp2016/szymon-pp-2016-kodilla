import java.util.Arrays;
import java.util.List;

public class StreamOne {

    private String name;
    private int age;

    @Override
    public String toString() {
        return name;
    }

    private StreamOne(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    static List<StreamOne> persons = Arrays.asList(
            new StreamOne("Max", 18),
            new StreamOne("Peter", 23),
            new StreamOne("Pamela", 23),
            new StreamOne("David", 12));

    public static void main(String[] args) {

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream()
                .filter(s -> s.contains("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("IntStream");

    }
}
