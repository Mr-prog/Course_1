package com.mr_prog.common.collections;

import com.mr_prog.common.data.City;

import java.time.LocalDate;
import java.util.*;

public class RunCollectionManager implements CollectionManager<Integer, City>{
    private Hashtable<Integer, City> collection;
    private LocalDate initDate;

    @Override
    public Hashtable getCollection() {
        return collection;
    }

    @Override
    public void add(Integer ID, City element) {
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
    public void replace_if_lowe() {
    }

    @Override
    public void remove_greater_key(Integer ID) {
    }

    @Override
    public void remove_lower_key(Integer ID) {

    }

    @Override
    public void filter_starts_with_name(String str) {

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
}
