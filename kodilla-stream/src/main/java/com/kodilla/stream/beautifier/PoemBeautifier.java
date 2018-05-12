package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public static void main(String[] args) {
    }
    public  void beautify(String txt_org, String txt_beauty, PoemDecorator poemdecorator){
        String  result =poemdecorator.decorate(txt_beauty, txt_org);
        System.out.println("Poemats after baeutifuer: " + result);
    }
    public String addAToB(String txt_org, String txt_beauty) {
        return txt_org+txt_beauty;
    }
    public String  addBToAtoB(String txt_org, String txt_beauty) {
        return txt_org+txt_beauty+txt_org;
    }
    public String  addAToAToBToB(String txt_org, String txt_beauty) {
        return txt_org+txt_org+txt_beauty+txt_beauty;
    }
    public String  bigLetter(String txt_org, String txt_beauty) {
        return txt_org + txt_org + txt_beauty + txt_beauty.toUpperCase();
    }
}
