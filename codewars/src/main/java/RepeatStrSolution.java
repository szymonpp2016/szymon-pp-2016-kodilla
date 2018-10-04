import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RepeatStrSolution {
    public static String repeatStr(  int repeat, final String string) {
        String string1 ="";
        while (repeat > 0) {
            string1 = new StringBuilder(string1).append(string).toString();
            repeat--;
        }
        return repeat<0 ? "": string1;
    }
}
/*
public class Solution {
    public static String repeatStr(final int repeat, final String string) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < repeat; i++) {
            sb.append(string);
        }

        return sb.toString();
    }
}

  public static String repeatStr(final int repeat, final String string) {
    return java.util.stream.IntStream.range(0, repeat).mapToObj(i -> string)
        .collect(java.util.stream.Collectors.joining()).toString();
  }
}

public class Solution {
  public static String repeatStr(final int repeat, final String string) {
    return repeat < 0 ? "" : String.join("", Collections.nCopies(repeat, string));
  }
}

*/