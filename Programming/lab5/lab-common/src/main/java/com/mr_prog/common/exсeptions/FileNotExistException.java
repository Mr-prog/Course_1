package com.mr_prog.common.exсeptions;

public class FileNotExistException extends FileException{

    FileNotExistException() {
        super("Cannot found file");
    }
}
