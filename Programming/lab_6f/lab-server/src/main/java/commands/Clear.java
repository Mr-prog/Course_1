package commands;

import content.City;
import util.CollectionManager;

public class Clear implements CommandAble {
    CollectionManager collection;
    final public static String description = "очистить коллекцию";


    public Clear(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) {
        collection.clear();
        return "Успешно очищено";
    }

    public String getDescription() {
        return description;
    }
}
