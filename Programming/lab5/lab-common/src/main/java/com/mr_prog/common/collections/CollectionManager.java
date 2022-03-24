package com.mr_prog.common.collections;

import com.mr_prog.common.data.City;

import java.util.Hashtable;

public interface CollectionManager<K ,T> {
    public Hashtable<K, T> getCollection();


    public void add(K ID, T element);

    public String show();

    public void updateID(Integer ID, City city);

    public void remove_key(Integer ID);

    public void clear();

    public void replace_if_lowe();

    public void remove_greater_key(Integer ID);

    public void remove_lower_key(Integer ID);

    public void filter_starts_with_name(String str);

    public void print_unique_meters_above_sea_level();

    public void print_field_ascending_agglomeration();


}
