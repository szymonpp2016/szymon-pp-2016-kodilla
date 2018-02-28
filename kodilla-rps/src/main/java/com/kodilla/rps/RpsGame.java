package com.kodilla.rps;

import java.util.*;

public class RpsGame {

    private Scanner scanner = new Scanner(System.in);
    private List<String> winningList = new ArrayList<>();
    private RpsProcess rpsProcess = new RpsProcess();
    private RpsPrepareGame rpsPrepareGame = new RpsPrepareGame();
    private RpsDisplayMessage rpsDisplayMessage = new RpsDisplayMessage(rpsProcess ,rpsPrepareGame.getRpsSchema());

    RpsGame(Integer version) {
        rpsDisplayMessage.setVersion(version);
        rpsProcess.setVersion(version);
        rpsPrepareGame.listPossibleAnswer(version);
    }

    public void newGame() {
        rpsDisplayMessage.welcome();
        rpsDisplayMessage.rule();
        rpsDisplayMessage.difficultVersionAsk();
        String siLevel= scanner.nextLine().toUpperCase();
        rpsProcess.setRpsDifficultLevel(siLevel);

        Integer round = 0;
        while ( round < 1) {
            rpsDisplayMessage.numberOfRoundAsk();
            round = scanner.nextInt();
        }
        Integer tempRound=round;
        while ( tempRound>0) {
            String result = play();
            winningList.add(result);
            tempRound--;
        }
        rpsDisplayMessage.nextGameAsk();
        String playAgain="";
        while(!(playAgain.equals("N")||playAgain.equals("X"))) {
            playAgain = scanner.next().toUpperCase();
        }
        if (playAgain.toUpperCase().equals("N")) {
            winningList.clear();
            newGame();
        }
        if (playAgain.toUpperCase().equals("X")) {
            rpsDisplayMessage.summary(round, winningList);
        }
    }

    private String play() {
        rpsDisplayMessage.possibleAnswerOptions();
        String answer="no";
        while(rpsProcess.optionsAnswer(answer)) {
            rpsDisplayMessage.giveYourAnswer();
            answer = scanner.next();
        }
        Integer humanAnswer = Integer.parseInt(answer);
        rpsProcess.siAnswer(humanAnswer);
        Integer siAnswer = rpsProcess.siAnswer(humanAnswer);
        String win = rpsProcess.rpsWinner(humanAnswer, siAnswer);
        rpsDisplayMessage.adverts();
        rpsDisplayMessage.roundWinner(humanAnswer, siAnswer, win);
        rpsDisplayMessage.nextRoundWait();
        return win;
    }
}
