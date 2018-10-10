import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecodeResistorColors {
    public static String decodeResistorColors(String bands) {
        List<String> listOfBands  = Arrays.asList(bands.toLowerCase().split(" "));
        List<String>  listOfOrginalBnds = Arrays.asList("black:brown:red:orange:yellow:green:blue:violet:grey:white".toLowerCase().split(":"));


        String ohmsValueOfResistor=null;
        String colorNr1=listOfBands.get(0);
        String colorNr2=listOfBands.get(1);
        String colorNr3=listOfBands.get(2);
        String colorNr4=null;
        if(listOfBands.size()>3) {
            colorNr4=listOfBands.get(3);
            if(colorNr4.toLowerCase().equals("gold"))  {
                colorNr4="5%";
            } else {
                colorNr4="10%";
            }
        } else {
            colorNr4 = "20%";
        }
        int nr1 = listOfOrginalBnds.indexOf(colorNr1);

        int nr2 = listOfOrginalBnds.indexOf(colorNr2);

        int nr3 = listOfOrginalBnds.indexOf(colorNr3);



        ohmsValueOfResistor=(((nr1*10+nr2)*Math.pow(10,nr3 ))+ " ohms, "+colorNr4 );

        if(nr3>1&&nr3<5)ohmsValueOfResistor=(((nr1*10+nr2)*Math.pow(10,nr3 )*0.001)+ "k ohms, "+colorNr4 );

        if(nr3>4) ohmsValueOfResistor=(((nr1*10+nr2)*Math.pow(10,nr3 )*0.000001)+ "M ohms, "+colorNr4 );


        System.out.println(ohmsValueOfResistor);



        return  ohmsValueOfResistor;
    }
}
