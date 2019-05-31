package com.example.source;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "abcefghijklmn";
        //CharSequence c = s1.subSequence(1,3);
        String[] s2 = s1.split("a");
        for (String s3 : s2) {
            System.out.print("s3 = " + s3 + "; ");
        }
        //System.out.print(c);
    }
}
