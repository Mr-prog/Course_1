package com.mr_prog.common.csv;

import com.mr_prog.common.data.City;

import java.util.Hashtable;

public class CSVMaker implements CSV{
    private final String SPLITTER = ",";


    @Override
    public String makeToCSV(Hashtable<Integer, City> hashtable) {
        String file = "";
        for(City city: hashtable.values()){
            file += city.getId() + SPLITTER + city.getName() + SPLITTER + city.getCoordinates().getX()
            + SPLITTER + city.getCoordinates().getY() + SPLITTER
            + city.getAgglomeration() + SPLITTER +
            SPLITTER + city.getArea() + SPLITTER + city.getCreationDate() +
            SPLITTER + city.getGovernment() + SPLITTER + city.getPopulation() + SPLITTER +
            city.getMetersAboveSeaLevel() + SPLITTER + city.getStandardOfLiving() + SPLITTER + city.getGovernor() +
            "\n";
        }
        return file;
    }
}
