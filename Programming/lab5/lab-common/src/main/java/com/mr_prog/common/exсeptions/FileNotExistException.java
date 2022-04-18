package com.mr_prog.common.exсeptions;

public class FileNotExistException extends FileException{

    public FileNotExistException() {
        super("Cannot found file");
    }
}
