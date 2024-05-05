package com.shamil.insure.insure.Utils;

import java.util.Random;

public class GenerateID {

    String prefix = "";


    public String generateInsID() {
        String InsID = "";
        prefix = "INS";
        int a = (int) (Math.random() * (9 + 1));
        char b = (char) (new Random().nextInt(26) + 'A');
        int c = (int) (Math.random() * (999 + 100) + 100);
        InsID = prefix + a + b + c;
        return InsID;
    }

    public String generateReNum() {
        prefix = "TX";
        int a = (int) (Math.random() * (9 + 1));
        char b = (char) (new Random().nextInt(26) + 'A');
        int c = (int) (Math.random() * (9999 + 1000) + 1000);

        return prefix + a + b + c;
    }
}
