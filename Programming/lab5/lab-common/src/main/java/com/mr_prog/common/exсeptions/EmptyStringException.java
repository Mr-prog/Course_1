package com.mr_prog.common.exсeptions;

public class EmptyStringException extends InvalidDataException{
    public EmptyStringException() {
        super("String is empty");
    }
}
