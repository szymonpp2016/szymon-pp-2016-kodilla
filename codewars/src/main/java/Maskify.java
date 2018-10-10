public class Maskify {

    public static String maskify(String str) {

        if (str.length() > 4) {
            String word = str;
            word = word.substring(0, str.length() - 4).replaceAll(".", "#");
            str = word + str.substring(str.length() - 4, str.length());
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(maskify("Spy"));
    }




    public static String maskifyBEST(String str) {
        if (str.length() <= 4) return str;
        String result = "";
        for (int i = 0; i < str.length()-4; i++) {
            result += "#";
        }
        return result + str.substring(str.length()-4);
    }
}