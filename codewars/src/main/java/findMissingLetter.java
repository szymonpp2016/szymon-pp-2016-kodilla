import java.util.ArrayList;
import java.util.Arrays;

public class findMissingLetter {

    public static char findMissingLetter(char[] array)
    {
        ArrayList<Character> fullAlfabhet =new ArrayList<Character>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
        final String s;
        String letter="A" ;
        int UpperCaseSign=0;

        for(int i=0;i<array.length;i++)
        {
            String x= String.valueOf(array[i]);
            array[i]=x.toUpperCase().charAt(0);
            if(array[i]==x.charAt(0))  UpperCaseSign=1;

            int firstNumberOfLetter = fullAlfabhet.indexOf(array[0]);
            if(array[i]!= fullAlfabhet.get(i + firstNumberOfLetter)) {
                letter = String.valueOf(fullAlfabhet.get(i + firstNumberOfLetter));
                i=array.length;
            }
        }
        if(UpperCaseSign==1) {
            s = letter.toUpperCase();
        } else {
            s = letter.toLowerCase();
        }
        return s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[]{'a','b','c','d','f'}));

    }
}
