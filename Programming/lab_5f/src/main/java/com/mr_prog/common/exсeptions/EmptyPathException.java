package com.mr_prog.common.exсeptions;

public class EmptyPathException extends FileException {
    public EmptyPathException() {
        super("This path is empty");
    }
}
