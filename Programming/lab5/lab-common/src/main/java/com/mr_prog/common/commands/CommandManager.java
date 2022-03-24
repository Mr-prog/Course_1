package com.mr_prog.common.commands;

import com.mr_prog.common.collections.CollectionManager;
import com.mr_prog.common.data.*;
import com.mr_prog.common.io.ConsoleManager;
import com.mr_prog.common.io.InputManager;
import com.mr_prog.common.io.OutputManager;
import com.mr_prog.common.io.ReaderWriter;


import java.util.HashMap;

import java.util.Map;
import java.util.Stack;

public class CommandManager implements CommandAble {
    private Map<String, Command> map;
    private CollectionManager<Integer, City> collectionManager;
    private InputManager inputManager;
    private ReaderWriter fileManager;
    private boolean isRunning;
    private String currentScriptFileName;

    private static Stack<String> callStack = new Stack<>();

    public CommandManager(CollectionManager<Integer, City> collectionManager, InputManager inputManager, ReaderWriter fileManager) {
        isRunning = false;
        this.inputManager = inputManager;
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;

        currentScriptFileName = "";
        map = new HashMap<String, Command>();
        addCommand("help", (a) -> System.out.println("Pomogite"));


    }

    @Override
    public void addCommand(String key, Command cmd) {
        map.put(key, cmd);
    }


    @Override
    public void runCommand(String key, String arg) {

    }

    @Override
    public void runCommand(String key) {
        runCommand(key, null);
    }

    @Override
    public boolean hasCommand(String s) {
        return map.containsKey(s);
    }

    @Override
    public void consoleMode() {
        inputManager = new ConsoleManager();
        isRunning = true;
        while(isRunning){
            System.out.print("enter command (help to get command list): ");
            CommandWrapper pair = inputManager.readCommand();
            runCommand(pair.getCommand(), pair.getArg());
        }
    }

    @Override
    public void fileMode(String path) {
    }

    public Map<String, Command> getMap() {
        return map;
    }

    /*    public static String getHelp(){
        return
    }
 */
}
