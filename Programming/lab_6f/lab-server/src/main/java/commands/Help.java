package commands;


import content.City;
import exeptions.InvalidArgumentException;
import util.CollectionManager;

import java.util.Map;

public class Help implements CommandAble {
    final public static String description = "вывести справку по доступным командам";
    final public static String name = "help";

    private Map<String, CommandAble> commands;


    public Help(Map<String, CommandAble> commands) {
        this.commands = commands;
    }


    @Override
    public String run(String arg, City obj) throws InvalidArgumentException {
        String resp = "";
        for (String key : commands.keySet()) {
            resp += key + ": " + commands.get(key).getDescription() + "\n";
        }
        return resp;
    }

    public String getDescription() {
        return description;
    }
}
