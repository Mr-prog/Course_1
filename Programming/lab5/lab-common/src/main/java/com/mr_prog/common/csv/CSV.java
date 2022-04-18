package com.mr_prog.common.csv;

import com.mr_prog.common.data.City;

import java.util.Hashtable;

public interface CSV {
    public String makeToCSV(Hashtable<Integer, City> hashtable);
}
