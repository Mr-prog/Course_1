package com.mr_prog.common.csv;

import com.mr_prog.common.data.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Scanner;

public class ReadCSV {
    private Hashtable<Integer, City> collection;
    public ReadCSV(){

    }

    public Hashtable toHashTable(String file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        Scanner scanner = null;
        int index = 0;

        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            City city;
            int ID = 0;
            String name = null;
            double x = 0;
            int y = 0;
            double agglomeration = 0;
            double area = 0;
            java.time.LocalDate localDate = null;
            Government government = null;
            long population = 0;
            long meters = 0;
            StandardOfLiving standardOfLiving = null;
            Human governor = null;


            assert line != null;
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    ID = Integer.parseInt(data);
                else if (index == 1)
                    name = data;
                else if (index == 2)
                    x = Double.parseDouble(data);
                else if (index == 3)
                    y = Integer.parseInt(data);
                else if (index == 4)
                    agglomeration = Double.parseDouble(data);
                else if (index == 5)
                    area = Double.parseDouble(data);
                else if (index == 6)
                    localDate = LocalDate.parse(data);
                else if (index == 7)
                    government = Government.valueOf(data);
                else if (index == 8)
                    population = Long.parseLong(data);
                else if (index == 9)
                    meters = Long.parseLong(data);
                else if (index == 10)
                    standardOfLiving = StandardOfLiving.valueOf(data);
                else if (index == 11)
                    governor = new Human(Integer.parseInt(data));
                index++;

            }
            Coordinates coordinates = new Coordinates(x, y);
            city = new City(name,coordinates,localDate,area,population,meters,
            agglomeration, government, standardOfLiving, governor);

            collection.put(ID, city);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collection;
    }
}
