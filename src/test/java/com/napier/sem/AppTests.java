package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTests {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }


    @Test
    void printPopulationOfCountryIfNull() { app.getPopulationOfACountry(null); }

    @Test
    void printPopulationOfCountry() { app.getPopulationOfACountry("Italy"); }


    @Test
    void testPrintPopulationInCityIfNull() {  }

    @Test
    void printPopulationInDistrictIfNull() { }

    @Test
    void testPopulationInContinentIfNull() { }

    void testGlobalPopulationIfNull() {}

    @Test
    void testPrintCitiesTestNull()
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



}