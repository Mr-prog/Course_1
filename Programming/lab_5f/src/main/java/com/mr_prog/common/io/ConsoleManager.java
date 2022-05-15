package com.mr_prog.common.io;

import java.util.Scanner;



public class ConsoleManager extends InputManagerScanner {
    public ConsoleManager() {
        super(new Scanner(System.in));
        getScanner().useDelimiter("\n");
    }
}
