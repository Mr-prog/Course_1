package com.mr_prog.common.exсeptions;

public class EmptyCollectionException extends CommandException{
    public EmptyCollectionException() {
        super("Collection is empty");
    }
}
