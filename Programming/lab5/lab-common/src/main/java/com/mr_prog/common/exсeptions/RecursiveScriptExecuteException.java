package com.mr_prog.common.exсeptions;


public class RecursiveScriptExecuteException extends CommandException{
    public RecursiveScriptExecuteException(){
        super("recursive script execute attempt");
    }
}
