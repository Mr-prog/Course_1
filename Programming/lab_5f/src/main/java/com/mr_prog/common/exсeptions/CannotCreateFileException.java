package com.mr_prog.common.exсeptions;

public class CannotCreateFileException extends FileException {
    public CannotCreateFileException() {
        super("Cannot create file");
    }
}
