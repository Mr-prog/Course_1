package com.mr_prog.common.io;

public class OutputManager {
    static public void print(Object msg)
    {
        System.out.println(msg);
    }

    static public void printErr(String msg){
        System.out.println("Error: " + msg);
    }
}
