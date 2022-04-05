package com.mr_prog.common.exсeptions;

public class CannotCreateFileException extends FileException{
    CannotCreateFileException() {
        super("Cannot create file");
    }
}
