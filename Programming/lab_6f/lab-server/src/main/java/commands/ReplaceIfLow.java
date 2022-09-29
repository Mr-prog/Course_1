package commands;


import content.City;
import exeptions.InvalidArgumentException;
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
            throw new InvalidArgumentException("Эта команда требует аргумент: ключ элемента коллекции");
        }

        if (!collection.contains(arg)) {
            throw new InvalidArgumentException("Элемент с таким ключом не существует");
        }

        return collection.replaceIfLow(arg, obj);
    }

    public String getDescription() {
        return description;
    }
}
