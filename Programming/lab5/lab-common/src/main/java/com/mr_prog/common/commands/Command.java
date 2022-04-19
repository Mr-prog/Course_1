package com.mr_prog.common.commands;

import com.mr_prog.common.exсeptions.InvalidEnumException;

@FunctionalInterface
public interface Command {
    public void run(String arg) throws InvalidEnumException;
}
