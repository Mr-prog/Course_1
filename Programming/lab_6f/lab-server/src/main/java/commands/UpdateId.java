package commands;


import content.City;
import exeptions.InvalidArgumentException;
import util.CollectionManager;

public class UpdateId implements CommandAble {
    CollectionManager collection;

    final public static String description = "обновить значение элемента коллекции, id которого равен заданному";

    public UpdateId(CollectionManager collection) {
        this.collection = collection;
    }

    @Override
    public String run(String arg, City obj) throws InvalidArgumentException {
        Integer id;
        try {
            id = Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("Эта команда требует аргумент: id");
        }
        if (!collection.containsID(id)) {
            throw new InvalidArgumentException("Элемента с таким id нет");
        }

        collection.update(id, obj);
        return "Фильм успешно отредактирован";
    }

    public String getDescription() {
        return description;
    }
}
