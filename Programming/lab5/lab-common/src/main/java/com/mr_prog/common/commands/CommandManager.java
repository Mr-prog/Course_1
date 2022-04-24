package com.mr_prog.common.commands;

import com.mr_prog.common.collections.CollectionManager;
import com.mr_prog.common.data.*;
import com.mr_prog.common.exсeptions.*;
import com.mr_prog.common.io.*;


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
            System.out.println("1 - info");
            System.out.println("2 - show");
            System.out.println("3 - insert");
            System.out.println("4 - update_id");
            System.out.println("5 - remove_key");
            System.out.println("6 - clear");
            System.out.println("7 - save");
            System.out.println("8 - execute_script");
            System.out.println("9 - exit");
            System.out.println("10 - replace_if_low");
            System.out.println("11 - remove_greater_key");
            System.out.println("12 - remove_lower_key");
            System.out.println("13 - filter_starts_with_name");
            System.out.println("14 - print_unique_meters_above_sea_level");
            System.out.println("15 - print_field_ascending_agglomeration");
            });
        addCommand("info", (a) -> System.out.println(collectionManager.getInfo()));
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

            if (callStack.contains(currentScriptFileName)) throw new RecursiveScriptExecuteException();

            callStack.push(currentScriptFileName);
            CommandManager process = new CommandManager(collectionManager, inputManager, fileManager);
            process.fileMode(a);
            callStack.pop();
            print("Success " + a);

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




        addCommand("1", (a) -> System.out.println(collectionManager.getInfo()));
        addCommand("2", (a) ->{
            if(collectionManager.getCollection().isEmpty()) print("Collection is empty");
            else print(collectionManager.serializeCollection());
        });
        addCommand("3", (a) -> {
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
        addCommand("4", (a) -> {
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
        addCommand("5", (a) -> {
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
        addCommand("6", (a) -> collectionManager.clear());
        addCommand("7", (a) -> {
            if(!(a == null || a.equals(""))) fileManager.setPath(a);
            if (collectionManager.getCollection().isEmpty()) print("collection is empty");
            if(!fileManager.write(collectionManager.serializeCollection())) throw new CommandException("cannot save collection");
        });
        addCommand("8", (a) ->{
            if (a == null || a.equals("")){
                throw new MissedCommandArgumentException();
            }

            if (callStack.contains(currentScriptFileName)) throw new RecursiveScriptExecuteException();

            callStack.push(currentScriptFileName);
            CommandManager process = new CommandManager(collectionManager, inputManager, fileManager);
            process.fileMode(a);
            callStack.pop();
            print("Success " + a);

        });
        addCommand("9", (a) -> isRunning=false);
        addCommand("10", (a) -> {
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
        addCommand("11", (a) -> {
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
        addCommand("12", (a) ->{
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
        addCommand("13", (a) -> {
            if (a == null || a.equals("")){
                throw new MissedCommandArgumentException();
            }

            collectionManager.filter_starts_with_name(a);

        });
        addCommand("14", (a) ->{
            collectionManager.print_unique_meters_above_sea_level();
        });
        addCommand("15", (a) ->{
            collectionManager.print_field_ascending_agglomeration();
        });

    }

    @Override
    public void addCommand(String key, Command cmd) {
        map.put(key, cmd);
    }


    @Override
    public void runCommand(String key, String arg) throws InvalidDataException {
        try{
            if (!hasCommand(key)) throw new IllegalCommandException();
            map.get(key).run(arg);
        }
        catch(CommandException|InvalidDataException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void runCommand(String key) throws InvalidDataException {
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
    public void consoleMode() throws InvalidDataException {
        inputManager = new ConsoleManager();
        isRunning = true;
        while(isRunning){
            System.out.print("Enter command (help to get full cmd list): ");
            CommandWrapper pair = inputManager.readCommand();
            runCommand(pair.getCommand(), pair.getArg());
        }
    }


    @Override
    public void fileMode(String path) throws InvalidDataException {
        currentScriptFileName = path;
        isRunning = true;
        inputManager = new FileInputManager(path);
        isRunning = true;
        while(isRunning && inputManager.getScanner().hasNextLine()){
            CommandWrapper pair = inputManager.readCommand();
            runCommand(pair.getCommand(), pair.getArg());
        }
    }

    public Map<String, Command> getMap() {
        return map;
    }

}
