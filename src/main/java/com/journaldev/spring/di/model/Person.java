package com.journaldev.spring.di.model;

/**
 * Created by NICOLA on 14/07/2016.
 */
public class Person {

    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    String surname;
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    String country;
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    String nationality;
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
