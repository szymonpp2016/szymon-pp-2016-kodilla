package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public static void main(String[] args) {
    }

    public  void /* String */ beautify(String txt_org, String txt_beauty, PoemDecorator poemdecorator){
        String  result =poemdecorator.decorate(txt_beauty, txt_org);
        System.out.println("Poemats after baeutifuer: " + result);
    }
}
