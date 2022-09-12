package commands;

import com.sun.javaws.exceptions.InvalidArgumentException;
import content.City;

public interface CommandAble {
    String run(String arg, City obj) throws InvalidArgumentException;
    String getDescription();
}
