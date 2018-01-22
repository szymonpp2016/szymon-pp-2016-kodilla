package com.kodilla.stream.lambda;

import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.reference.poemReferenceBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("PoemBeautifier with lambda ");
        poemBeautifier.beautify(" poemat poemat poemat   ", " ABC", (txt_org, txt_beauty) -> txt_org+txt_beauty);
        poemBeautifier.beautify(" poemat 2 poemat 2 poemat 2  ", " LALALA", (txt_org, txt_beauty) -> txt_org+txt_org+txt_beauty+txt_beauty);

        System.out.println("PoemBeautifier with method references");
        poemBeautifier.beautify(" poemat poemat poemat   ", " ABC", poemReferenceBeautifier::addAToB);
        poemBeautifier.beautify(" poemat poemat poemat   ", " ABC", poemReferenceBeautifier::addAToAToBToB);
        poemBeautifier.beautify(" poemat poemat poemat   ", " ABC", poemReferenceBeautifier::bigLetter);

    }
}
