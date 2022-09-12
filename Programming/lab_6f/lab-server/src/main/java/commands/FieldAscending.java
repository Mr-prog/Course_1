package commands;

import content.City;
import util.CollectionManager;

public class FieldAscending implements CommandAble {
    CollectionManager collection;
    final public static String description = "вывести элементы коллекции в порядке возрастания";

    /**
     * Constructor of print_ascending command
     *
     * @param collection CollectionManager instance
     */
    public FieldAscending(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) {
        return collection.getAscending();
    }

    public String getDescription() {
        return description;
    }
}
