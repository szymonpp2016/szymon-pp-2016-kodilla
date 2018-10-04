import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Kata {
    static int findShort(String s) {
        List list = new LinkedList<Integer>();
        int counter = 0;
            for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '&& s.charAt(i+1)!=' ')    {
               list.add(counter);
                counter=-1;
            }
            counter++;
        }
        list.add(counter);
        Collections.sort(list);
        return   (int) list.get(0);
    }
}



/*
    static int findShort(String s) {
        int counter = 0;
        int finalcounter=s.length();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if(s.charAt(i)==' '&& s.charAt(i+1)!=' ')    {
                if(finalcounter>counter) finalcounter=counter;
                counter=-1;
                System.out.println("find"+finalcounter);
            }
            counter++;
        }
        return finalcounter>counter ? finalcounter=counter :finalcounter  ;
    }
}


public class Kata {
    public static int findShort(String s) {
        return Stream.of(s.split(" "))
          .mapToInt(String::length)
          .min()
          .getAsInt();
    }
}


  public static int findShort(String s) {
    return java.util.Arrays.stream(s.split(" ")).mapToInt(n -> n.length()).min().getAsInt();
  }
}

Just use the appropriate method: String#split().

String string = "004-034556";
String[] parts = string.split("-");
String part1 = parts[0]; // 004
String part2 = parts[1]; // 034556
 */