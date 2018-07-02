public class DRoot {


    public static int digital_root(int n) {

        String nString= String.valueOf(n);
        while (digitalIntPorces(nString)>9) {
            nString=String.valueOf(digitalIntPorces(nString));
        }
    return digitalIntPorces(nString);}

    public static void main(String[] args) {
        System.out.println(digital_root(1618888));
    }

    public static int digitalIntPorces(String nString) {
        String nDigitalString="0";
        int sumDigital=0;
        for(int i=0; i <nString.length();i++) {
            nDigitalString = nString.substring(i, i + 1);
            sumDigital = sumDigital + Integer.parseInt(nDigitalString);
        }
        return sumDigital;}


 // rozwiazania
    public static int digital_rootBest(int n) {
        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }




    public static int digital_rootBest2(int n) {
        final int result = String.valueOf(n).chars().reduce(0, (acc, curr) -> acc + (curr - '0'));
        return result < 10 ? result : digital_root(result);
    }
}

