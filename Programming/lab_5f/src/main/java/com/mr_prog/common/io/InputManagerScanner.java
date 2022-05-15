package com.mr_prog.common.io;

import com.mr_prog.common.commands.CommandWrapper;
import com.mr_prog.common.data.*;
import com.mr_prog.common.exсeptions.EmptyStringException;
import com.mr_prog.common.exсeptions.InvalidDataException;
import com.mr_prog.common.exсeptions.InvalidEnumException;
import com.mr_prog.common.exсeptions.InvalidNumberException;


import java.io.InputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManagerScanner implements InputManager {
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

    public String readName() throws NoSuchElementException {
        System.out.println("Set name");
        checkCmd();
        String s = scanner.nextLine().trim();
        if (s.equals("")) {
            System.out.println("Enter a value");
            readName();
        }

        return s;
    }


    public Double readCordX() throws InvalidNumberException, NoSuchElementException {
        System.out.println("Set x");
        checkCmd();
        double x = 0;
        try {
            x = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Value must be a num");
            readCordX();
        }
        return x;
    }

    public int readCordY() throws NoSuchElementException {
        System.out.println("Set y");
        checkCmd();
        int y = 0;
        try {
            y = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Value must be a num");
            readCordY();
        }
        return y;
    }

    public Coordinates readCoordinates() throws InvalidNumberException, NoSuchElementException {
        int y = readCordY();
        double x = readCordX();
        return new Coordinates(x, y);
    }

    public Double readArea() throws NoSuchElementException {
        System.out.println("Set area");
        checkCmd();
        double area = 0;
        try {
            area = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Value must be a num");
            readArea();
        }
        if (area <= 0 || Double.isNaN(area)) {
            System.out.println("Value must be greater than 0");
        }
        return area;
    }

    public Long population() throws InvalidNumberException, NoSuchElementException {
        System.out.println("Set population");
        checkCmd();
        long population = 0;
        try {
            population = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Value must be a num");
            population();
        }
        if (population <= 0) {
            System.out.println("Value must be greater than 0");
            population();
        }
        return population;
    }

    public Long metersAboveSeaLevel() throws InvalidNumberException, NoSuchElementException {
        System.out.println("Set sea_level");
        checkCmd();
        long sea = 0;
        try {
            sea = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Value must be a num");
            metersAboveSeaLevel();
        }
        return sea;
    }

    public double agglomeration() throws InvalidNumberException, NoSuchElementException {
        System.out.println("Set agglomeration");
        checkCmd();
        double agg = 0;
        try {
            agg = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Value must be a num");
            agglomeration();
        }
        return agg;
    }

    public Government readGovernment() throws InvalidEnumException, NoSuchElementException {
        System.out.println("Set Government \n1 - COMMUNISM \n2 - DESPOTISM \n3 - NOOCRACY");
        checkCmd();
        try {
            String res = scanner.nextLine();
            if (Integer.parseInt(res) == 1){
                return Government.COMMUNISM;
            } else if (Integer.parseInt(res) == 2) {
                return Government.DESPOTISM;
            } else if (Integer.parseInt(res) == 3) {
                return Government.NOOCRACY; }
            return Government.valueOf(res);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid value");
        }
        return readGovernment();
    }

    public StandardOfLiving readStandardOfLiving() throws NoSuchElementException {
        System.out.println("Set standard_of_living \n1 - VERY_HIGH \n2 - MEDIUM \n3 - ULTRA_LOW \n4 - NIGHTMARE");
        checkCmd();


        try {
            String res = scanner.nextLine();
            if (Integer.parseInt(res) == 1){
                return StandardOfLiving.VERY_HIGH;
            } else if (Integer.parseInt(res) == 2) {
                return StandardOfLiving.MEDIUM;
            } else if (Integer.parseInt(res) == 3) {
                return StandardOfLiving.ULTRA_LOW;
            } else if (Integer.parseInt(res) == 4) {
                return StandardOfLiving.NIGHTMARE;
            }

            return StandardOfLiving.valueOf(res);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid value");
        }
        return readStandardOfLiving();
    }

    public Integer readHeight() throws NoSuchElementException {
        System.out.println("Set height");
        checkCmd();
        Integer h = 0;
        try {
            h = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Height must be number and greater than 0");
            readHeight();
        }
        if (h <= 0) readHeight();
        if (h == null) {
            readHeight();
        }
        return h;
    }

    public CommandWrapper readCommand() throws NoSuchElementException{
        checkCmd();
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


    public City readCity() throws InvalidDataException, NoSuchElementException {

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

    public void checkCmd() {
        if (scanner.hasNext()){

        } else {
            System.exit(0);
        }
    }
}
