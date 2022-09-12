package commands;

import com.sun.javaws.exceptions.InvalidArgumentException;
import content.City;
import util.CollectionManager;

public class Insert implements CommandAble {
    CollectionManager collection;
    final public static String description = "добавить новый элемент с заданным ключом";

    public Insert(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) throws InvalidArgumentException {
        System.out.println("insert" + arg + obj);
        if (arg == null) {
            throw new InvalidArgumentException(new String[]{"Эта команда требует аргумент: ключ элемента коллекции"});
        }
        if (collection.contains(arg)) {
            throw new InvalidArgumentException(new String[]{"Элемент с таким ключом уже существует"});
        }
        if (obj == null) {
            System.out.println("obj == null");
            obj = City.prompt();
            System.out.println(obj);
        }
        collection.insert(arg, obj);
        return "Город успешно добавлен";
    }

    public String getDescription() {
        return description;
    }
}
