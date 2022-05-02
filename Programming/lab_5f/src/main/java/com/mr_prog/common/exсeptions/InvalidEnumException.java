package com.mr_prog.common.exсeptions;

public class InvalidEnumException extends InvalidDataException {
    public InvalidEnumException() {
        super("Wrong constant");
    }
}
