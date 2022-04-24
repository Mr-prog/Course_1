package com.mr_prog.common.exсeptions;

public class InvalidNumberException extends InvalidDataException {
    public InvalidNumberException(){
        super("invalid number format");
    }
    public InvalidNumberException(String msg){
        super(msg);
    }
}