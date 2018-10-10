import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeDecoder {


    public static String decode(String morseCode) {
        int signOfNextWord=-1;
        String answer="";
        morseCode=morseCode.replaceAll("\\s{3}", "  ");
        String[] words = morseCode.replaceAll("\\s{3}", "  ").split("\\ ");

        for(String name: words) {
            if(name.length()==0) {
                answer+=" ";
                signOfNextWord*=(-1);
            } else
                answer+=name;
        }
        answer=answer.replaceAll("^\\s{0,}", "");
        answer= answer.replaceAll("( )+", "x");

        return answer;}


    public static void main(String[] args) {

        System.out.println(decode(" .... . -.--   .--- ..- -.. .   ----       "));
        System.out.println(".... . -.--   .--- ..- -.. .   ----");
    }







    public static String decodeBEST (String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(MorseCodeDecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        return Arrays.stream(word.split(" ")).map( s->s).collect(Collectors.joining());
    }  //FUNKCA MORSEDECODE była wpisana w FUNKCJE ZADANIA alinia powyżej brzmi wtedy jak poniżej:

    // return Arrays.stream(word.split(" ")).map(MorseCode::get).collect(Collectors.joining());
}

/* public class MorseCodeDecoder {
    public static String decode(String morseCode) {

        String answer="";
        String[] words = morseCode.replaceAll("\\s{3}", "  ").split("\\ ");

        for(String name: words) {
            if(name.length()==0) {
                answer+=" ";
            } else {
                answer+=MorseCode.get(name);
            }
        }
        answer=answer.replaceAll("^\\s{0,3}", "");
        return answer;}

} */





