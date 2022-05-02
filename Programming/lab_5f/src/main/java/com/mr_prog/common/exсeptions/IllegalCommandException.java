package com.mr_prog.common.exсeptions;

public class IllegalCommandException extends CommandException {
    public IllegalCommandException() {
        super("Wrong command");
    }
}
