package com.gthm.libraries.mapstruct.entity;

public enum Country {

    INDIA,
    USA,
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