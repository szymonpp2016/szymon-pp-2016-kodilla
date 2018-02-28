package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RpsProcess {

    private String rpsLevel;
    private Integer humanWin;
    private Integer computerWin;
    private Integer version;

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setRpsDifficultLevel(String rpsLevel) {
        this.rpsLevel = rpsLevel;
    }

    public Integer siAnswer(Integer humanAnswer) {
        Integer goodAnswer = rpsGoodAnswer(humanAnswer);
        Integer siAnswer;
        Integer siAnswerNumber;

        int randomNumber = 100;
        Random random = new Random();
        siAnswerNumber = random.nextInt(randomNumber);

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < randomNumber / 3 + 1; i++) {
            answerList.add(1);
            answerList.add(2);
            answerList.add(3);
            if (rpsLevel.equals("H")) answerList.add(goodAnswer);
        }
        siAnswer = answerList.get(siAnswerNumber);
        return siAnswer;
    }

    public String rpsWinner(Integer humanAnswer, Integer siAnswer) {
        if (humanAnswer.equals(siAnswer)) return "Draw";
        if (humanAnswer == siAnswer - 1) return "Computer";
        if (humanAnswer - 2 == siAnswer) return "Computer";
        return "Human";
    }

    private Integer rpsGoodAnswer(Integer humanAnswer) {
        Integer goodAnswer = 0;
        if (humanAnswer == 1) {
            goodAnswer = 2;
        }
        if (humanAnswer == 2) {
            goodAnswer = 3;
        }
        if (humanAnswer == 3) {
            goodAnswer = 1;
        }
        return goodAnswer;
    }

    String summary(Integer round, List<String> winningList) {
        Integer humanWin = 0;
        Integer computerWin = 0;
        while (winningList.contains("Draw")) winningList.remove("Draw");
        int size1 = winningList.size();

        while (winningList.contains("Human")) {
            winningList.remove("Human");
            humanWin++;
        }
        while (winningList.contains("Computer")) {
            winningList.remove("Computer");
            computerWin++;
        }
        this.humanWin = humanWin;
        this.computerWin = computerWin;
        int size2 = winningList.size();
        if (size2 > size1 - size2) return "Computer";
        if (size2 < size1 - size2) return "Human";
        return "Draw";
    }

    public Integer getHumanWin() {
        return humanWin;
    }

    public Integer getComputerWin() {
        return computerWin;
    }

    public Boolean optionsAnswer(String answer) {
        if (version == 2) {
            return !answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4") && !answer.equals("5");
        } else {
            return !answer.equals("1") && !answer.equals("2") && !answer.equals("3");
        }
    }
}

