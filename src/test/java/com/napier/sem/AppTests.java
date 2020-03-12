package com.napier.sem;
import org.junit.Assert;
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
    void printPopulationOfCountryIfNull()
    {
        Assert.assertEquals(  "If the Country is null, the population is null"  ,null ,  app.getPopulationOfACountry(null));
    }


    @Test
    void testPopulationInCityIfNull()
    {
        Assert.assertEquals("If the name of city is null, the population must be null" , null , app.getPopulationOfACity(null));

    }

    @Test
    void testRegionNull() {
        Assert.assertEquals("Region Population must be null", null, app.getPopulationOfRegion(null));
    }


    @Test
    void testDistrictIfNull() {
        Assert.assertEquals("District Population must be null", null, app.getPopulationDistrict(null));
    }


    @Test
    void testPopulationInContinentIfNull()
    {
        Assert.assertEquals("Cntinent Population must be null", null, app.getPopulationOfAContinent(null));
    }

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