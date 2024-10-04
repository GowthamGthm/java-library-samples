package com.gthm.entity;

public enum Country {

    INDIA,
    UAS,
    RUSSIA,
    CHINA,
    ISRAEL,
    UK,
    GERMANY,
    FRANCE;

    String countryName;

    Country() {
    }

    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}