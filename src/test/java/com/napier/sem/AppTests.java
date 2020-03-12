package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTests {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void getCountryTest(){
        Country cnt = new Country("Italy");
     assertEquals(cnt.getName(), "Italy");
     ArrayList<Country> countries = new ArrayList<>();
     countries.add(cnt);
     app.printCountries(countries);
     assertEquals(cnt.getName(), "null");
     countries.add(cnt);
     app.printCountries(countries);
    }


    @Test
    void printCitiesTestNull()
    {
        app.printCities(null);
    }

    // City is empty
    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCities(cities);
    }

    // City contains null
    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCities(cities);
    }

    @Test
    void getPeopleLinvingInCitiesorNotTest(){

    }
}