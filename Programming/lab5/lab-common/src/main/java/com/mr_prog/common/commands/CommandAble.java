package com.mr_prog.common.commands;

import com.mr_prog.common.exсeptions.InvalidEnumException;

public interface CommandAble {

    public void addCommand(String key, Command cmd);


    public void runCommand(String key, String arg) throws InvalidEnumException;


    public void runCommand(String key);

    public boolean hasCommand(String s);


    public void consoleMode();


    public void fileMode(String path);
}
