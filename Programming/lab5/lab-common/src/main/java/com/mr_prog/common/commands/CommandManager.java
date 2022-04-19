package com.mr_prog.common.commands;

import com.mr_prog.common.collections.CollectionManager;
import com.mr_prog.common.data.*;
import com.mr_prog.common.exсeptions.*;
import com.mr_prog.common.io.ConsoleManager;
import com.mr_prog.common.io.InputManager;
import com.mr_prog.common.io.OutputManager;
import com.mr_prog.common.io.ReaderWriter;


import java.util.HashMap;

import java.util.Map;
import java.util.Stack;

import static com.mr_prog.common.io.OutputManager.print;

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
        addCommand("help", (a) -> {
            for(Command command: map.values()){
                System.out.println(command.toString());
            }
        } );
        addCommand("info", (a) -> collectionManager.getInfo());
        addCommand("show", (a) ->{
            if(collectionManager.getCollection().isEmpty()) print("Collection is empty");
            else print(collectionManager.serializeCollection());
        });
        addCommand("insert", (a) -> {
            int id;
            if(a==null || a.equals("")) {
                throw new MissedCommandArgumentException();
            }
            id = Integer.parseInt(a);

            if(collectionManager.getCollection().isEmpty()) print("Collection is empty");
            if (collectionManager.checkID(id)) throw new InvalidCommandArgumentException("no such id");
            City city = inputManager.readCity();
            city.setID(id);
            collectionManager.insert(id, city);
        } );
        addCommand("update_id", (a) -> {
            int id;
            if(a==null || a.equals("")) {
                throw new MissedCommandArgumentException();
            }
            id = Integer.parseInt(a);

            if (collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
            if (!collectionManager.checkID(id)) throw new InvalidCommandArgumentException("no such id");
            City city = inputManager.readCity();
            city.setID(id);
            collectionManager.updateID(id, city);
        });
        addCommand("remove_key", (a) -> {
            int id;
            if (a == null || a.equals("")){
                throw new MissedCommandArgumentException();
            }
            try {
                id = Integer.parseInt(a);
            } catch (NumberFormatException e) {
                throw new InvalidCommandArgumentException("id must be Integer");
            }

            if(collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
            if (!collectionManager.checkID(id)) throw new InvalidCommandArgumentException("no such id");

            collectionManager.remove_key(id);
        });
        addCommand("clear", (a) -> collectionManager.clear());
        addCommand("save", (a) -> {
            if(!(a == null || a.equals(""))) fileManager.setPath(a);
            if (collectionManager.getCollection().isEmpty()) print("collection is empty");
            if(!fileManager.write(collectionManager.serializeCollection())) throw new CommandException("cannot save collection");
        });
        addCommand("execute_script", (a) ->{
            if (a == null || a.equals("")){
                throw new MissedCommandArgumentException();
            }

            callStack.push(currentScriptFileName);
            CommandManager process = new CommandManager(collectionManager, inputManager, fileManager);
            process.fileMode(a);
            callStack.pop();
            print("Executed success " + a);

        });
        addCommand("exit", (a) -> isRunning=false);
        addCommand("replace_if_low", (a) -> {
            int id;
            if (a == null || a.equals("")){
                throw new MissedCommandArgumentException();
            }
            try {
                id = Integer.parseInt(a);
            } catch (NumberFormatException e) {
                throw new InvalidCommandArgumentException("id must be Integer");
            }

            if(collectionManager.getCollection().isEmpty()) throw new EmptyCollectionException();
            if (!collectionManager.checkID(id)) throw new InvalidCommandArgumentException("no such id");

            collectionManager.replace_if_lowe(id, inputManager.readCity());
        });
        addCommand("remove_greater_key", (a) -> {
            int id;
            if (a == null || a.equals("")){
                throw new MissedCommandArgumentException();
            }
            try {
                id = Integer.parseInt(a);
            } catch (NumberFormatException e) {
                throw new InvalidCommandArgumentException("id must be Integer");
            }

            collectionManager.remove_greater_key(id);
        });
        addCommand("remove_lower_key", (a) ->{
            int id;
            if (a == null || a.equals("")){
                throw new MissedCommandArgumentException();
            }
            try {
                id = Integer.parseInt(a);
            } catch (NumberFormatException e) {
                throw new InvalidCommandArgumentException("id must be Integer");
            }

            collectionManager.remove_lower_key(id);
        });
        addCommand("filter_starts_with_name", (a) -> {
            if (a == null || a.equals("")){
                throw new MissedCommandArgumentException();
            }

            collectionManager.filter_starts_with_name(a);

        });
        addCommand("print_unique_meters_above_sea_level", (a) ->{
            collectionManager.print_unique_meters_above_sea_level();
        });
        addCommand("print_field_ascending_agglomeration", (a) ->{
            collectionManager.print_field_ascending_agglomeration();
        });
    }

    @Override
    public void addCommand(String key, Command cmd) {
        map.put(key, cmd);
    }


    @Override
    public void runCommand(String key, String arg) throws InvalidEnumException {
        map.get(key).run(arg);
    }

    @Override
    public void runCommand(String key) {
        try {
            runCommand(key, null);
        } catch (InvalidEnumException e) {
            e.printStackTrace();
        }
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
            try {
                runCommand(pair.getCommand(), pair.getArg());
            } catch (InvalidEnumException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void fileMode(String path) {
    }

    public Map<String, Command> getMap() {
        return map;
    }

}
