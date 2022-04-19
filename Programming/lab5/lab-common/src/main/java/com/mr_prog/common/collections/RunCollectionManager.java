package com.mr_prog.common.collections;

import com.mr_prog.common.csv.CSVMaker;
import com.mr_prog.common.csv.ReadCSV;
import com.mr_prog.common.data.City;


import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class RunCollectionManager implements CollectionManager<Integer, City>{
    private Hashtable<Integer, City> collection;
    private LocalDate initDate;
    private CSVMaker csvMaker;
    private ReadCSV readCSV;

    public RunCollectionManager(){
            collection = new Hashtable<>();
            initDate = LocalDate.now();
            csvMaker = new CSVMaker();
            readCSV = new ReadCSV();

    }

    @Override
    public Hashtable getCollection() {
        return collection;
    }

    @Override
    public void insert(Integer ID, City element) {
        collection.put(ID, element);
    }


    @Override
    public String show() {
        return "Collections: " + collection.toString();
    }

    @Override
    public void updateID(Integer ID, City element) {
        collection.replace(ID, element);
    }

    @Override
    public void remove_key(Integer ID) {
        collection.remove(ID);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public void replace_if_lowe(Integer ID, City element) {
        if (collection.get(ID).getAgglomeration() < element.getAgglomeration()){
            collection.replace(ID, element);
        }
    }

    @Override
    public void remove_greater_key(Integer ID) {
        for (City city: collection.values()){
            if (city.getId() < ID){
                collection.remove(city.getId());
            }
        }
    }

    @Override
    public void remove_lower_key(Integer ID) {
        for (City city: collection.values()){
            if (city.getId() < ID){
                collection.remove(city.getId());
            }
        }
    }

    @Override
    public void filter_starts_with_name(String str) {
        for (City city: collection.values()){
            if (city.getName().startsWith(str)){
                collection.remove(city.getId());
            }
        }
    }

    @Override
    public void print_unique_meters_above_sea_level() {
        LinkedList<Long> meters = new LinkedList<>();
        System.out.print("unique salaries:");
        for (City city: collection.values()) {
            if (!meters.contains(city.getMetersAboveSeaLevel())) {
                System.out.println(city.getMetersAboveSeaLevel());
                meters.add(city.getMetersAboveSeaLevel());
            }
        }
    }

    @Override
    public void print_field_ascending_agglomeration() {
        Double [] agglomeration = new Double[collection.size()];
        for (City city: collection.values()){
            Arrays.fill(agglomeration, city.getAgglomeration());
        }
        System.out.println(Arrays.stream(agglomeration).sorted());
    }

    public void readCollection(String csv){
        if(csv==null){
            collection = new Hashtable<>();
        } else {
            collection = readCSV.toHashTable(csv);
        }
    }

    @Override
    public String serializeCollection() {
        if (collection == null || collection.isEmpty()) return "";
        return csvMaker.makeToCSV(collection);
    }

    @Override
    public boolean checkID(Integer id) {
        for (City city: collection.values()){
            if (city.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getInfo() {
        return null;
    }



    @Override
    public void sort() {
        Hashtable<Integer, City> sortedCollection = collection;
        for (City city: collection.values()){
            double num = city.getAgglomeration();
            for (City city1: collection.values()){
                if (city.getAgglomeration() < city1.getAgglomeration()){
                    num += 1;
                }
            }
            int checker = 0;
            for (City city1: collection.values()){
                checker += 1;
                if (checker == num){
                    sortedCollection.replace(city.getId(), city1);
                }
            }
        }
        collection = sortedCollection;
    }
}
