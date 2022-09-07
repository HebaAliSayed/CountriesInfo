package com.jwhh.countriesinfo;

public class contryInfo {
    String country;
    String capital;
    int gov;

    public contryInfo(String country,String capital,int gov){
        this.country=country;
        this.capital=capital;
        this.gov=gov;

    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public int getGov() {
        return gov;
    }
    public String toString(){
        String s="This is some informations about %s. /n The number of governorates of this country is %d, and it's capital is %s. ",country,gov,capital;
        return s;
    }
}
