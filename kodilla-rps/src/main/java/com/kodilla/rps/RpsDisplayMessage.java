package com.kodilla.rps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RpsDisplayMessage {

    private HashMap<Integer, String> prepareSchema;
    private Integer version;
    private RpsProcess rpsProcess;

    RpsDisplayMessage(RpsProcess rpsProcess, HashMap<Integer, String> prepareSchema) {
        this.rpsProcess =rpsProcess;
        this.prepareSchema=prepareSchema;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    void welcome(){
        if(version==1) System.out.println("Welcome to the game: Paper, stone, scissors \n");
        if(version==2) System.out.println("Welcome to the game: Paper, stone, scissors, lizard, Spock \n");
    }

    void rule(){
        if(version==1) {
            System.out.println("Game rules:\n" +
                    " a) stone crushes scissors,\n" +
                    " b) scissors cut paper,\n" +
                    " c) paper covers the stone..");
        }
        if(version==2) {
            System.out.println("Game rules:\n" +
                    " a) stone crushes scissors,\n" +
                    " b) scissors cut paper,\n" +
                    " c) paper covers the stone,\n" +
                    " d) the stone crushes the lizard, \n" +
                    " e) the lizard poisons Spock,\n" +
                    " f) Spock breaks the scissors, \n" +
                    " g) the scissors are wounding the lizard,\n" +
                    " h) the lizard eats paper, \n" +
                    " i) paper proves Spock's mistake,\n" +
                    " j) Spock crushes the stone. ");
        }
    }

    void difficultVersionAsk(){
        System.out.print("\n Game difficult: \n [H + enter] - hard difficult Version " +
                "\n [enter] - normal difficult Version " +
                "\n enter:");
    }

    void nextGameAsk(){
        System.out.println("\n How is your decision? Enter: " +
                "\n [n + Enter] - Starting the game again"+
                "\n [x + Enter] - End of the game and summary ");
        System.out.print(":");
    }

    void possibleAnswerOptions() {
        System.out.println("Below are possible options: \n");
        for (Map.Entry<Integer, String> entry : prepareSchema.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("\n press the selected key and then [enter]");
    }

    void giveYourAnswer(){
        System.out.print("Give your answer:");
    }

    void roundWinner(int humanAnswer, int siAnswer, String win) {
        System.out.println("Yor answer is:" + prepareSchema.get(humanAnswer));
        System.out.println("The Computer answer is:" +prepareSchema.get(siAnswer));
        System.out.println("And the winner is: "+win);
    }

    void numberOfRoundAsk() {
        System.out.print("\n How many rounds do you want to play? \n :");
    }

    void summary(Integer round, List<String> winningList) {
        if (round != 0) {
            System.out.println("\n Each winner of round:");
            for (String wininglist : winningList) {
                System.out.println(wininglist);
            }
            System.out.println("\n The winner was:");
            System.out.println(rpsProcess.summary(round, winningList));
            System.out.println("\n The score is: Human " + rpsProcess.getHumanWin() + ":" + rpsProcess.getComputerWin()+" Computer");

        } else {
            System.out.println("There was no game?");
        }
    }

    void adverts() {
        try {
            System.out.print("\n rock,");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("paper,");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("scissors!");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(" \n\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void nextRoundWait() {
        try {
            System.out.print("next round!\n\n");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
