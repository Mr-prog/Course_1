package com.mr_prog.common.commands;

public interface CommandAble {

    public void addCommand(String key, Command cmd);


    public void runCommand(String key, String arg);


    public void runCommand(String key);

    public boolean hasCommand(String s);


    public void consoleMode();


    public void fileMode(String path);
}
