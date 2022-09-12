package com.mr_prog.common.csv;

import com.mr_prog.common.data.City;

import java.util.TreeMap;

public interface CSV {
    public String makeToCSV(TreeMap<Integer, City> hashtable);
}
