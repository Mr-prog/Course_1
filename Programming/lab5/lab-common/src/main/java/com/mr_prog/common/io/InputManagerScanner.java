package com.mr_prog.common.io;

import com.mr_prog.common.commands.CommandWrapper;
import com.mr_prog.common.data.Coordinates;
import com.mr_prog.common.data.Government;
import com.mr_prog.common.data.StandardOfLiving;

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
        String name = scanner.nextLine().trim();
        return name;
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
        Double area = scanner.nextDouble();
        return area;
    }

    public Long population() {
        Long population = scanner.nextLong();
        return population;
    }

    public Long metersAboveSeaLevel() {
        Long meter = scanner.nextLong();
        return meter;
    }

    public double agglomeration() {
        double agglomeration = scanner.nextDouble();
        return agglomeration;
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
        Integer height = scanner.nextInt();
        return height;
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
}
