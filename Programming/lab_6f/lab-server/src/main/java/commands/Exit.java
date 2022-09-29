package commands;

import content.City;
import util.CollectionManager;

public class Exit implements CommandAble {
    CollectionManager collection;
    final public static String description = "завершить программу";

    public Exit(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) {
        collection.save();
        System.out.println("Сохранено");
        return null;
    }

    public String getDescription() {
        return description;
    }
}
