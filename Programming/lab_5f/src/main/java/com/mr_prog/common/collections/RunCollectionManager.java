package com.mr_prog.common.collections;

import com.mr_prog.common.csv.CSVMaker;
import com.mr_prog.common.csv.ReadCSV;
import com.mr_prog.common.data.City;
import com.mr_prog.common.exсeptions.FileException;


import java.time.LocalDate;
import java.util.*;

public class RunCollectionManager implements CollectionManager<Integer, City>{
    private TreeMap<Integer, City> collection;
    private LocalDate initDate;
    private CSVMaker csvMaker;
    private ReadCSV readCSV;

    public RunCollectionManager(){
            collection = new TreeMap<>();
            initDate = LocalDate.now();
            csvMaker = new CSVMaker();
            readCSV = new ReadCSV();

    }

//    @Override
//    public TreeMap<Integer, City> getCollection() {
//        return collection;
//    }


    @Override
    public Hashtable<Integer, City> getCollection() {
        return null;
    }

    /**
     * adds new element
     * @param element
     * @param ID
    */
    @Override
    public void insert(Integer ID, City element) {
        collection.put(ID, element);
    }

    /**
     * show collection
     * @return
     */
    @Override
    public String show() {
        return "Collections: " + collection.toString();
    }

    /**
     * replace element by id
     * @param ID
     * @param element
     */
    @Override
    public void updateID(Integer ID, City element) {
        collection.replace(ID, element);
    }

    /**
     * remove element by id
     * @param ID
     */
    @Override
    public void remove_key(Integer ID) {
        collection.remove(ID);
    }


    @Override
    public void clear() {
        collection.clear();
    }

    /**
     * replace element by id if id < new id
     * @param ID
     * @param element
     */
    @Override
    public void replace_if_lowe(Integer ID, City element) {
        if (collection.get(ID).getAgglomeration() < element.getAgglomeration()){
            collection.replace(ID, element);
        }
    }

    /**
     * remove id if id > param
     * @param ID
     */
    @Override
    public void remove_greater_key(Integer ID) {
        for (City city: collection.values()){
            if (city.getId() < ID){
                collection.remove(city.getId());
            }
        }
    }

    /**
     * remove elements if id < param
     * @param ID
     */
    @Override
    public void remove_lower_key(Integer ID) {
        for (City city: collection.values()){
            if (city.getId() < ID){
                collection.remove(city.getId());
            }
        }
    }

    /**
     * insert element which begin with param
     * @param str
     */
    @Override
    public void filter_starts_with_name(String str) {
        for (City city: collection.values()){
            if (city.getName().startsWith(str)){
                collection.remove(city.getId());
            }
        }
    }

    /**
     * print unique meters above sea level
     */
    @Override
    public void print_unique_meters_above_sea_level() {
        LinkedList<Long> meters = new LinkedList<>();
        System.out.println("Unique sea level");
        for (City city: collection.values()) {
            if (!meters.contains(city.getMetersAboveSeaLevel())) {
                System.out.println(city.getMetersAboveSeaLevel());
                meters.add(city.getMetersAboveSeaLevel());
            }
        }
    }


    @Override
    public void print_field_ascending_agglomeration() {
        System.out.println("field ascending agglomeration :");
        sort();
        for (City city: collection.values()){
            System.out.println(city.getAgglomeration());
        }
    }

    public void readCollection(String csv) throws FileException {
        if(csv==null){
            collection = new TreeMap<>();
        } else {
            collection = readCSV.toTreeMap(csv);
        }
    }

    /**
     * write collection in file
     * @return
     */
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
        return "Hashtable size: " + Integer.toString(collection.size()) + "; initialization date: " + initDate.toString();
    }



    @Override
    public void sort() {
        TreeMap<Integer, City> sortedCollection = collection;
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
