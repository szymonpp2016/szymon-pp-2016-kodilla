import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Repeater {
    public static String repeat(String string,long n) {
        String newString = IntStream.range(0, (int) n).mapToObj(i -> string)
                .collect(Collectors.joining());
        return newString;
    }
}


/*
markus.benko
public class Repeater{
  public static String repeat(String string,long n){
    return string + (n < 2 ? "" : repeat(string, n - 1));
  }
} */