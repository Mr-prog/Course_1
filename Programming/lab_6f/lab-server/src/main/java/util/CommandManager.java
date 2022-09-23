package util;


import commands.*;
import exeptions.InvalidArgumentException;

import java.util.HashMap;
import java.util.Map;


public class CommandManager {
    private Map<String, CommandAble> commands = new HashMap<>();


    public CommandManager(CollectionManager collectionManager) {
        commands.put("info", new Info(collectionManager));
//        commands.put("execute_script", new ExecuteScript(this));
        commands.put("show", new Show(collectionManager));
        commands.put("insert", new Insert(collectionManager));
        commands.put("update_id", new UpdateId(collectionManager));
        commands.put("remove_key", new RemoveKey(collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("save", new Save(collectionManager));
        commands.put("exit", new Exit(collectionManager));
        commands.put("remove_greater_key", new RemoveLowerKey(collectionManager));
        commands.put("replace_if_low", new ReplaceIfLow(collectionManager));
        commands.put("remove_lower_key", new RemoveGreaterKey(collectionManager));
        commands.put("field_ascending", new FieldAscending(collectionManager));
        commands.put("help", new Help(commands));

    }

    public String run(String[] args) {
        try {
            return commands.get(args[0]).run(args.length > 1 ? args[1] : null, null);
        } catch (NullPointerException e) {
            return null;
        } catch (InvalidArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    public String runPrepared(Request req) {
        try {
            return commands.get(req.getCommand()).run(req.getArg(), req.getObj());
        } catch (NullPointerException e) {
            return null;
        } catch (InvalidArgumentException e) {
            return e.getMessage();
        }
    }
}