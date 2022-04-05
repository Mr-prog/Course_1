package com.mr_prog.common.exсeptions;

public class IllegalCommandException extends CommandException {
    IllegalCommandException() {
        super("Wrong command");
    }
}
