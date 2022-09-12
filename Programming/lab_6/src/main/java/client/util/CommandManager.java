package client.util;

import client.commands.Clear;
import client.commands.Commands;
import client.commands.Execute_script;
import client.commands.Exit;

import java.util.Map;

public class CommandManager {
    private Map<String, Commands> commands;

    CommandManager () {
        commands.put(Exit.key, new Exit());
    }

}
