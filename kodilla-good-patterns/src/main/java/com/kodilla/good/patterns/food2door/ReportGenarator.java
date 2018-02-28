package com.kodilla.good.patterns.food2door;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReportGenarator {

    private OrderDto confirm;
    ReportGenarator(OrderDto confirm) {
        this.confirm = confirm;
    }

    public void writeToFile(){

        String pathToSummaryFile="kodilla-good-patterns\\src\\main\\java\\com\\kodilla\\good\\patterns\\food2door\\summary.txt";

      // String directory = System.getProperty("java.class.path")+"\\summary.txt";
     //   System.out.println(directory);

       /* // dopsiałem możliwośc wyboru ścieżki dla wprawy -ale normalnie byłaby to zapewne lokacja

        //// wpisana na sztywno jak- `raport dla szefa` (a po skońćzeniu dnia   wysyłąna mailem or sth like that)
        System.out.println("Starting save the informataion about Order!");
        System.out.println("Would you like to write file in: ");
        Scanner read = new Scanner(System.in);

        System.out.println(" 1- current directory: "+ directory);
        System.out.println(" 2- this class path directory: \n "+ pathToSummaryFile);
        System.out.print(" 3 - write your own path \n :");
        String choseOption = read.nextLine();
        String path;
        if(choseOption.equals("1")) {
            path = directory;
        }
        if(choseOption.equals("2")) {
            path = pathToSummaryFile;
        } else {
            System.out.println("POdaj wląsna ścieżkę zapisu pliku");
            path = read.nextLine();
        } */

        System.out.println("Path to write the summary file: " + pathToSummaryFile);
        try (PrintWriter writeToFile = new PrintWriter(new FileWriter(pathToSummaryFile,true))) {
            writeToFile.println("\n Shop: " +confirm.getOrder().getOrderProductDate().getSuplier()
                    + ", product: "+confirm.getOrder().getOrderProductDate().getProduct()+ ", zadanie wykonane: " +confirm.isConfirmSendingOrder() );
            writeToFile.close();
        } catch (IOException e) {
            System.out.println("unable to write");
        }
    }
 }
