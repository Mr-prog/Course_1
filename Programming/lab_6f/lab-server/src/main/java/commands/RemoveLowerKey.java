package commands;

import com.sun.javaws.exceptions.InvalidArgumentException;
import content.City;
import util.CollectionManager;

public class RemoveLowerKey implements CommandAble{
    CollectionManager collection;
    final public static String description = "удалить из коллекции все элементы, превышающие заданный";


    public RemoveLowerKey(CollectionManager collection) {
        this.collection = collection;
    }


    @Override
    public String run(String arg, City obj) throws InvalidArgumentException {
        return "Удалено элементов: " + collection.removeLower(arg);
    }

    public String getDescription() {
        return description;
    }
}
