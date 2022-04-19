package com.mr_prog.common.io;

import com.mr_prog.common.commands.CommandWrapper;
import com.mr_prog.common.data.*;
import com.mr_prog.common.exсeptions.InvalidEnumException;


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
        System.out.println("Set name");
        String name;
        name = scanner.nextLine().trim();
        while (name == ""){
            name = scanner.nextLine().trim();
        }
        return name;
    }


    public Double readCordX() {
        System.out.println("Set x");
        double x;
        x = scanner.nextDouble();
        return x;
    }

    public int readCordY() {
        System.out.println("Set y");
        int y;
        y = scanner.nextInt();
        return y;
    }

    public Coordinates readCoordinates() {
        System.out.println("Set coordinates");
        int y = readCordY();
        double x = readCordX();
        return new Coordinates(x, y);
    }

    public Double readArea() {
        System.out.println("Set area");
        return scanner.nextDouble();
    }

    public Long population() {
        System.out.println("Set population");
        return scanner.nextLong();
    }

    public Long metersAboveSeaLevel() {
        System.out.println("Set sea_level");
        return scanner.nextLong();
    }

    public double agglomeration() {
        System.out.println("Set agglomeration");
        return scanner.nextDouble();
    }

    public Government readGovernment() throws InvalidEnumException {
        System.out.println("Set Government");
        String government = scanner.nextLine().trim();
        try{
            return Government.valueOf(scanner.nextLine());
        } catch(IllegalArgumentException e){
            throw new InvalidEnumException();
        }
    }

    public StandardOfLiving readStandardOfLiving() throws InvalidEnumException {
        System.out.println("Set standard_of_living");
        String standard = scanner.nextLine().trim();
        try{
            return StandardOfLiving.valueOf(standard);
        } catch(IllegalArgumentException e){
            throw new InvalidEnumException();
        }
    }

    public Integer readHeight() {
        System.out.println("Set height");
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


    public City readCity() throws InvalidEnumException {

        String name = readName();
        Coordinates coordinates = readCoordinates();
        Double area = readArea();
        Long population = population();
        Long meters = metersAboveSeaLevel();
        Double agglomeration = agglomeration();
        Government government = readGovernment();
        StandardOfLiving standardOfLiving = readStandardOfLiving();
        Integer height = readHeight();
        Human governor = new Human(height);
        LocalDate localDate = LocalDate.now();
        return new City(name, coordinates, localDate, area, population, meters,
                agglomeration, government, standardOfLiving, governor);
    }
}
