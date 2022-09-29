package commands;

import exceptions.InvalidArgumentException;
import util.Request;

public class RemoveKey extends CommandAble{
    final public static String name = "remove_key";
    final public static String description = "удалить элемент из коллекции по его ключу";

    @Override
    public Request getRequest(String arg) throws InvalidArgumentException {
        if (arg == null) {
            throw new InvalidArgumentException("Эта команда требует аргумент: ключ элемента коллекции");
        }
        return new Request(name, arg);
    }

    public String getDescription() {
        return description;
    }
}
