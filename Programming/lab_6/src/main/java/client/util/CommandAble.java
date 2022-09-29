package client.util;

import client.commands.Commands;

public interface CommandAble {
    public void addCommand(String key, Commands cmd);

    public boolean hasCommand(String s);

    public void consoleMode();

    public void fileMode(String path);
}
