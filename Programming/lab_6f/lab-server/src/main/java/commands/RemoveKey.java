package commands;

import com.sun.javaws.exceptions.InvalidArgumentException;
import content.City;
import util.CollectionManager;

public class RemoveKey implements CommandAble{
    CollectionManager collection;
    final public static String description = "удалить элемент из коллекции по его ключу";

    public RemoveKey(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) throws InvalidArgumentException {
        if (arg == null){
            throw new InvalidArgumentException(new String[]{"Эта команда требует аргумент: ключ элемента коллекции"});
        }
        if (!collection.contains(arg)) {
            throw new InvalidArgumentException(new String[]{"Элемента с таким ключом не существует"});
        }
        collection.removeKey(arg);
        return "Успешно удалено";
    }

    public String getDescription() {
        return description;
    }
}
