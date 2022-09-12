package commands;

import com.sun.javaws.exceptions.InvalidArgumentException;
import content.City;
import util.CollectionManager;

public class ReplaceIfLow implements CommandAble{
    CollectionManager collection;

    final public static String description = "заменить значение по ключу, если новое значение больше старого";

    public ReplaceIfLow(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) throws InvalidArgumentException {

        if (arg == null){
            throw new InvalidArgumentException(new String[]{"Эта команда требует аргумент: ключ элемента коллекции"});
        }

        if (!collection.contains(arg)) {
            throw new InvalidArgumentException(new String[]{"Элемент с таким ключом не существует"});
        }

        return collection.replaceIfLow(arg, obj);
    }

    public String getDescription() {
        return description;
    }
}
