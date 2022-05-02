package com.mr_prog.common.exсeptions;

public class InvalidDataFormatException extends InvalidDataException {
    public InvalidDataFormatException() {
        super("Data format must be yyyy-MM-dd");
    }
}
