package com.mr_prog.common.exсeptions;

public class MissedCommandArgumentException extends InvalidCommandArgumentException{
    public MissedCommandArgumentException() {
        super("Missed command argument");
    }
}
