package com.mr_prog.common.io;

import com.mr_prog.common.commands.CommandWrapper;
import com.mr_prog.common.data.*;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public abstract class InputManagerScanner implements InputManager {
    private Scanner scanner;

    public InputManagerScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readName() {
        return scanner.nextLine().trim();
    }


    public Double readCordX() {
        double x;
        x = scanner.nextDouble();
        return x;
    }

    public int readCordY() {
        int y;
        y = scanner.nextInt();
        return y;
    }

    public Coordinates readCoordinates() {
        int y = readCordY();
        double x = readCordX();
        return new Coordinates(x, y);
    }

    public Double readArea() {
        return scanner.nextDouble();
    }

    public Long population() {
        return scanner.nextLong();
    }

    public Long metersAboveSeaLevel() {
        return scanner.nextLong();
    }

    public double agglomeration() {
        return scanner.nextDouble();
    }

    public Government readGovernment() {
        String government = scanner.nextLine().trim();
        return Government.valueOf(government);
    }

    public StandardOfLiving readStandardOfLiving() {
        String standard = scanner.nextLine().trim();
        return StandardOfLiving.valueOf(standard);
    }

    public Integer readHeight() {
        return scanner.nextInt();
    }

    public CommandWrapper readCommand() {
        String cmd = scanner.nextLine();
        if (cmd.contains(" ")) {
            String[] cmdArr = cmd.split(" ", 2);
            cmd = cmdArr[0];
            String arg = cmdArr[1];
            return new CommandWrapper(cmd, arg);
        } else {
            return new CommandWrapper(cmd);
        }
    }


    public City readCity(){
        String name = readName();
        Coordinates coordinates = readCoordinates();
        Double area = readArea();
        Long population = population();
        Long meters = metersAboveSeaLevel();
        double agglomeration = agglomeration();
        Government government = readGovernment();
        StandardOfLiving standardOfLiving = readStandardOfLiving();
        Integer height = readHeight();
        Human governor = new Human(height);
        LocalDate localDate = LocalDate.now();
        return new City(name, coordinates, localDate, area, population, meters,
                agglomeration, government, standardOfLiving, governor);
    }
}
