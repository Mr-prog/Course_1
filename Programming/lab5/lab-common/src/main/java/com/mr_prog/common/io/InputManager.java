package com.mr_prog.common.io;

import com.mr_prog.common.commands.Command;
import com.mr_prog.common.commands.CommandWrapper;
import com.mr_prog.common.data.City;
import com.mr_prog.common.data.Government;
import com.mr_prog.common.data.StandardOfLiving;
import com.mr_prog.common.exсeptions.EmptyStringException;
import com.mr_prog.common.exсeptions.InvalidDataException;
import com.mr_prog.common.exсeptions.InvalidEnumException;
import com.mr_prog.common.exсeptions.InvalidNumberException;

import java.util.Scanner;

public interface InputManager {

    public String readName() throws EmptyStringException;

    public Double readCordX() throws InvalidNumberException;

    public int readCordY() throws InvalidNumberException;

    public Double readArea() throws InvalidNumberException;

    public Long population() throws InvalidNumberException;

    public Long metersAboveSeaLevel() throws InvalidNumberException;

    public double agglomeration() throws InvalidNumberException;

    public Government readGovernment() throws InvalidEnumException;

    public StandardOfLiving readStandardOfLiving() throws InvalidEnumException;

    public Integer readHeight() throws InvalidNumberException;

    public CommandWrapper readCommand();

    public Scanner getScanner();

    public City readCity() throws InvalidEnumException, InvalidDataException;

}

