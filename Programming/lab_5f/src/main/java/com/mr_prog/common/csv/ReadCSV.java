package com.mr_prog.common.csv;

import com.mr_prog.common.data.*;
import com.mr_prog.common.exсeptions.FileException;
import com.mr_prog.common.exсeptions.FileIllegalFormatException;

import java.io.*;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Scanner;

public class ReadCSV {
    private Hashtable<Integer, City> collection;

    public ReadCSV() {
        collection = new Hashtable<>();
    }

    /**
     * read collection
     * @param file
     * @return
     */
    public Hashtable toHashTable(String file) {
        int index = 0;
        int n = file.split("[,|\n]").length / 12;
        String[] arr = new String[file.split(",|\n").length];
        for (String str : file.split(",|\n")) {
            arr[index] = str;
            index += 1;
        }


        for (int i = 0; i < n; i++) {
            try {

                City city;
                int ID = Integer.parseInt(arr[12 * i]);
                String name = arr[1 + 12 * i];
                double x = Double.parseDouble(arr[2 + 12 * i]);
                int y = Integer.parseInt(arr[3 + 12 * i]);
                double agglomeration = Double.parseDouble(arr[4 + 12 * i]);
                double area = Double.parseDouble(arr[5 + 12 * i]);
                LocalDate localDate = LocalDate.parse(arr[6 + 12 * i]);
                Government government = Government.valueOf(arr[7 + 12 * i]);
                long population = Long.parseLong(arr[8 + 12 * i]);
                long meters = Long.parseLong(arr[9 + 12 * i]);
                StandardOfLiving standardOfLiving = StandardOfLiving.valueOf(arr[10 + 12 * i]);
                int height = Integer.parseInt(arr[11 + 12 * i]);
                Human governor = new Human(height);
                Coordinates coordinates = new Coordinates(x, y);
                city = new City(name, coordinates, localDate, area, population, meters,
                        agglomeration, government, standardOfLiving, governor);
                city.setID(ID);
                collection.put(ID, city);
            } catch (Exception e) {
                System.out.println("Illegal data in file");
                System.exit(0);
                return new Hashtable<Integer, City>();
            }
        }


        return collection;
    }
}
