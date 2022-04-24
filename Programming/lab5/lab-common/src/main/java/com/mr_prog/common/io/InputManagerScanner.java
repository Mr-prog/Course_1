package com.mr_prog.common.io;

import com.mr_prog.common.commands.CommandWrapper;
import com.mr_prog.common.data.*;
import com.mr_prog.common.exсeptions.EmptyStringException;
import com.mr_prog.common.exсeptions.InvalidDataException;
import com.mr_prog.common.exсeptions.InvalidEnumException;
import com.mr_prog.common.exсeptions.InvalidNumberException;


import java.time.LocalDate;
import java.util.Date;
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

    public String readName() throws EmptyStringException {
        System.out.println("Set name");
        String s = scanner.nextLine().trim();
        if (s.equals("")){
            throw new EmptyStringException();
        }
        return s;
    }


    public Double readCordX() throws InvalidNumberException {
        System.out.println("Set x");
        double x;
        try{
            x = Double.parseDouble(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        if (Double.isNaN(x)) throw new InvalidNumberException("Invalid float value");
        return x;
    }

    public int readCordY() throws InvalidNumberException {
        System.out.println("Set y");
        int y;
        try{
            y = Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        return y;
    }

    public Coordinates readCoordinates() throws InvalidNumberException {
        int y = readCordY();
        double x = readCordX();
        return new Coordinates(x, y);
    }

    public Double readArea() throws InvalidNumberException {
        System.out.println("Set area");
        double area;
        try{
            area = Double.parseDouble(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        if (area <= 0 || Double.isNaN(area)) throw new InvalidNumberException("Must be greater than 0");
        return area;
    }

    public Long population() throws InvalidNumberException {
        System.out.println("Set population");
        long population;
        try{
            population = Long.parseLong(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        if (population <= 0) throw new InvalidNumberException("Must be greater than 0");
        return population;
    }

    public Long metersAboveSeaLevel() throws InvalidNumberException {
        System.out.println("Set sea_level");
        long sea;
        try{
            sea = Long.parseLong(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        return sea;
    }

    public double agglomeration() throws InvalidNumberException {
        System.out.println("Set agglomeration");
        double agg;
        try{
            agg = Double.parseDouble(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        return agg;
    }

    public Government readGovernment() throws InvalidEnumException {
        System.out.println("Set Government");
        try{
            return Government.valueOf(scanner.nextLine());
        } catch(IllegalArgumentException e){
            throw new InvalidEnumException();
        }
    }

    public StandardOfLiving readStandardOfLiving() throws InvalidEnumException {
        System.out.println("Set standard_of_living");
        try{
            return StandardOfLiving.valueOf(scanner.nextLine());
        } catch(IllegalArgumentException e){
            throw new InvalidEnumException();
        }
    }

    public Integer readHeight() throws InvalidNumberException {
        System.out.println("Set height");
        int h;
        try{
            h = Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        if (h <= 0) throw new InvalidNumberException("Must be greater than 0");
        return h;
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


    public City readCity() throws InvalidDataException {

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
