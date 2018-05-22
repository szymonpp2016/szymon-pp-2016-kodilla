package com.kodilla.sudoku;

import java.util.concurrent.TimeUnit;

public class SudokuDisplayMessage {

    static void welcome(){
        System.out.println("Welcome to the game: Sudoku");
    }

    static void rule(){
        System.out.println("Game rules:\n" +
                " * Sudoku rozgrywa się na planszy o rozmiarach 9x9 pól,\n" +
                "   częściowo wypełnionej liczbami. ,\n" +
                " *  Zadaniem gracza - a w naszym przypadku algorytmu \n" +
                " jest uzupełnienie pozostałych pól, wedle zasady, \n" +
                " że dana cyfra może występować tylko raz: \n" +
                " * w każdym wierszu, \n" +
                " * w każdej kolumnie," +
                " * w każdym bloku (wyjaśnienie poniżej)." +
                " Przez \"blok\" rozumiemy zaznaczone na powyższej ilustracji bloki po 3x3 pola. ,\n" +
                " Na powyższej ilustracji możesz zobaczyć, że plansza dzieli się na 9 takich bloków. ");
    }

    static void giveYourCellAnswer(){
        System.out.print("Give your answer (x <enter>,y<enter>,wartosc<enter>)  :");
    }

    static void yourAnswerIS(int x, int y, int cellNumber){
        System.out.print("You type (x,y,wartosc): "+x+","+y+","+cellNumber);
    }

    static void nextRoundAsk(){
        System.out.println("\n How is your decision? Enter: " +
                "\n [Y + Enter] - play still the game  "+
                "\n [N + Enter] - Computer callculeting (end game) ");
        System.out.print(":");
    }
    static void nextRound() {
        try {
            System.out.print(" \n next round!\n\n");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


