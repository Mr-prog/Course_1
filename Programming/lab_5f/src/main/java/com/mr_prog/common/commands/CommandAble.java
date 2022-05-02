package com.mr_prog.common.commands;

import com.mr_prog.common.exсeptions.InvalidDataException;
import com.mr_prog.common.exсeptions.InvalidEnumException;

public interface CommandAble {

    public void addCommand(String key, Command cmd);


    public void runCommand(String key, String arg) throws InvalidDataException;


    public void runCommand(String key) throws InvalidDataException;

    public boolean hasCommand(String s);


    public void consoleMode() throws InvalidDataException;


    public void fileMode(String path) throws InvalidDataException;
}
