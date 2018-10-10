import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class findMissingLetter {

    public static char findMissingLetter(char[] array)
    {
        ArrayList<Character> fullAlfabhet =new ArrayList<Character>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
        final String s;
        String letter="A" ;
        int UpperCaseSign=0;

        for(int i=0;i<array.length;i++)
        {
            final String s1 = array.toString().toUpperCase();
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

    private static char findMissingLetter1(char[] array)
    {
        ArrayList<Character> fullAlfabhet =new ArrayList<Character>(Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
        char[] newAlfabhet = new char[array.length];
        int counter=0;
        for ( char myChar :array) {
            newAlfabhet[array[myChar]] = Character.toUpperCase(myChar);
            counter++;
        }
        int firstNumberOfLetter = fullAlfabhet.indexOf(newAlfabhet[0]);
        String  missingLetter=null;
        for(int i=0;i<newAlfabhet.length;i++)
        {
             if(newAlfabhet[i]!= fullAlfabhet.get(i + firstNumberOfLetter)) {
             missingLetter = String.valueOf(fullAlfabhet.get(i + firstNumberOfLetter));
                i=newAlfabhet.length;
            }
        }
        return missingLetter.charAt(0);
    }




    public static void main(String[] args) {
        System.out.println(findMissingLetter1(new char[]{'a','b','c','d','f'}));

    }
}
