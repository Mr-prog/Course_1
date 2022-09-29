package commands;


import content.City;
import exeptions.InvalidArgumentException;

public interface CommandAble {
    String run(String arg, City obj) throws InvalidArgumentException;
    String getDescription();
}
