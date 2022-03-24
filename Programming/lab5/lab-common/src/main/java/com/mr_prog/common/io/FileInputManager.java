package com.mr_prog.common.io;

import java.util.Scanner;

public class FileInputManager extends InputManagerScanner{
    public FileInputManager(String path) {
        super(new Scanner(new FileManager(path).read()));
    }
}
