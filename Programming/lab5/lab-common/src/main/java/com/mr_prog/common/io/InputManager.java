package com.mr_prog.common.io;

import com.mr_prog.common.commands.Command;
import com.mr_prog.common.commands.CommandWrapper;
import com.mr_prog.common.data.City;
import com.mr_prog.common.data.Government;
import com.mr_prog.common.data.StandardOfLiving;
import com.mr_prog.common.exсeptions.InvalidEnumException;

import java.util.Scanner;

public interface InputManager {

    public String readName();

    public Double readCordX();

    public int readCordY();

    public Double readArea();

    public Long population();

    public Long metersAboveSeaLevel();

    public double agglomeration();

    public Government readGovernment() throws InvalidEnumException;

    public StandardOfLiving readStandardOfLiving() throws InvalidEnumException;

    public Integer readHeight();

    public CommandWrapper readCommand();

    public Scanner getScanner();

    public City readCity() throws InvalidEnumException;

}

