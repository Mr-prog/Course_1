package commands;

import content.City;
import util.CollectionManager;

public class Show implements CommandAble {
    CollectionManager collection;
    final public static String description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";


    public Show(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) {
        return collection.toString();
    }

    public String getDescription() {
        return description;
    }
}
