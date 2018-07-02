import java.util.Arrays;

public class FindHighAndLow {
    public static String HighAndLow(String numbers) {

        int tempMax;
        int tempMin;
        String[] arrayStringList=numbers.trim().split("\\s+");
        int[] arrayIntList= new int[arrayStringList.length];
        for(int i=0;i< arrayStringList.length;i++)
        {
            arrayIntList[i]=Integer.parseInt(arrayStringList[i]);
        }
        tempMax=arrayIntList[0];
        tempMin=arrayIntList[0];
        for(int i=0;i<arrayIntList.length;i++){

            if(arrayIntList[i]>tempMax) tempMax=arrayIntList[i];
            if(arrayIntList[i]<tempMin) tempMin=arrayIntList[i];
        }
        System.out.println(tempMax+" "+tempMin);
        return tempMax+" "+tempMin;
    }

    public static void main(String[] args) {
    String numbers="1 9 3 4 -5";

        System.out.println(HighAndLow(numbers));
    }

    public static String HighAndLowbest (String numbers) {

        int min = Arrays.stream(numbers.split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .min()
                .getAsInt();

        int max = Arrays.stream(numbers.split(" "))
                .mapToInt(i -> Integer.parseInt(i))
                .max()
                .getAsInt();

        return String.format("%d %d", max, min);
    }
}

