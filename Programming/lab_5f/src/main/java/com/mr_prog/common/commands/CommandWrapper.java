package com.mr_prog.common.commands;

public class CommandWrapper {
    private final String argument;
    private final String command;

    public CommandWrapper(String cmd, String arg) {
        argument = arg;
        command = cmd;
    }

    public CommandWrapper(String cmd) {
        argument = null;
        command = cmd;
    }

    public String getCommand() {
        return command;
    }

    public String getArg() {
        return argument;
    }
}
