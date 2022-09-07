package com.jwhh.countriesinfo;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    public static List<contryInfo> getCountries(){

        List<contryInfo>c=new ArrayList<>();
        c.add(new contryInfo("Egypt","Cairo",27));
        c.add(new contryInfo("Italy","Roma",80));
        c.add(new contryInfo("Nerway","Oslo",20));
        c.add(new contryInfo("India","New Delhi",497));
        c.add(new contryInfo("China","Beijing",117));
        c.add(new contryInfo("United States","Washington",50));
        c.add(new contryInfo("Russia","Moscow",85));
        c.add(new contryInfo("Morocco","Rabat",17));
        c.add(new contryInfo("Turkey","Ankara",81));
        c.add(new contryInfo("Iraq","Baghdad",18));
        return c;
    }
}
