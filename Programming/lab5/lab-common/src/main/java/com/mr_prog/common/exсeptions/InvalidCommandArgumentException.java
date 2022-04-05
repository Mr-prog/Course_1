package com.mr_prog.common.exсeptions;

public class InvalidCommandArgumentException extends CommandException{
    public InvalidCommandArgumentException(String msg) {
        super(msg);
    }
}
