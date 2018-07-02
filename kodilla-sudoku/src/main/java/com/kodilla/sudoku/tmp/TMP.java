package com.kodilla.sudoku;

import org.apache.commons.lang3.Range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TMP {


    List<Integer> possibleValues =new ArrayList<>();

    public TMP() {
        Integer INT=2;
        Collections.addAll(possibleValues, 1, 2, 3, 4);

        final Range<Integer> between = Range.between(1, 10);
        System.out.println("co to"+between.contains(1));

        System.out.println(possibleValues.size());
        System.out.println(INT);
        System.out.println(possibleValues.indexOf(INT));
        possibleValues.remove(INT);
        System.out.println(possibleValues.size());
    }

    public static void main(String[] args) {

       new TMP();



    }
}
