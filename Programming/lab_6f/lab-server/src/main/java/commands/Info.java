package commands;

import content.City;
import util.CollectionManager;

public class Info implements CommandAble {
    CollectionManager collection;
    final public static String description = "вывести в стандартный поток вывода информацию о коллекции";


    public Info(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) {
        return collection.getInfo();
    }

    public String getDescription() {
        return description;
    }
}
