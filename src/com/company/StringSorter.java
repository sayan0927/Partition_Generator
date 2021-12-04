package com.company;

import java.util.Comparator;

public class StringSorter implements Comparator<String> {
    @Override


    //sorts a list of string in ascending order of length of strings
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
