package com.kodilla.stream.reference;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public class poemReferenceBeautifier

{
        public static String addAToB(String txt_org, String txt_beauty) {
            return txt_org+txt_beauty;
        }

        public static String  addBToAtoB(String txt_org, String txt_beauty) {
            return txt_org+txt_beauty+txt_org;
        }
        public static String  addAToAToBToB(String txt_org, String txt_beauty) {
        return txt_org+txt_org+txt_beauty+txt_beauty;
        }
        public static String  bigLetter(String txt_org, String txt_beauty) {
        return toUpperCase(txt_org+txt_org+txt_beauty+txt_beauty);
    }


}
