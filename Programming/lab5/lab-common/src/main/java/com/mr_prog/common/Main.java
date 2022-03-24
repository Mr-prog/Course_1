package com.mr_prog.common;

import com.mr_prog.common.collections.CollectionManager;
import com.mr_prog.common.collections.RunCollectionManager;
import com.mr_prog.common.commands.CommandManager;
import com.mr_prog.common.data.City;
import com.mr_prog.common.io.ConsoleManager;
import com.mr_prog.common.io.FileManager;
import com.mr_prog.common.io.InputManager;

import java.io.PrintStream;

public final class Main {
    public static void main(String[] args) throws Exception{

        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        CollectionManager<Integer, City> collectionManager = new RunCollectionManager();
        FileManager fileManager = new FileManager();
        InputManager consoleManager = new ConsoleManager();
        CommandManager commandManager = new CommandManager(collectionManager,consoleManager,fileManager);
        commandManager.consoleMode();
    }
}
