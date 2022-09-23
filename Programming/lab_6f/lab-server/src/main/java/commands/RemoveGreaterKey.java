package commands;


import content.City;
import exeptions.InvalidArgumentException;
import util.CollectionManager;

public class RemoveGreaterKey implements CommandAble{
    CollectionManager collection;
    final public static String description = "удалить из коллекции все элементы, ключ которых превышает заданный";


    public RemoveGreaterKey(CollectionManager collection) {
        this.collection = collection;
    }


    @Override
    public String run(String arg, City obj) throws InvalidArgumentException {
        if (arg == null){
            throw new InvalidArgumentException("Эта команда требует аргумент: ключ элемента коллекции");
        }

        return "Удалено элементов: " + collection.removeGreaterKey(arg);
    }

    public String getDescription() {
        return description;
    }
}
