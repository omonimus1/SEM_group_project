package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Authors: Davide Pollicino, Magdalena Calkova, Simona Georgieva, Simone Piazzini
 * COURSE: Software Engineering Methods (SET08103)
 * Last Modified: 15/03/2020
 * AppIntegrationTest is a testing class that tests the connection to the SQL database and  the methods that use the connection from the App
 */

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    // Test for getCountriesinContinent
    @Test
    void getTopCountriesinContinentTest()
    {
        ArrayList<Country> countryList = new ArrayList<Country>();
        countryList = app.getCountriesinContinent("Europe");
        assertEquals(countryList.get(0).getName(), "Albania");
        assertEquals(countryList.get(0).getContinent(), "Europe");
        assertEquals(countryList.get(0).getPopulation(), 3401200);
    }


    // Test for getTopCountriesinRegion
    @Test
    void getTopCountriesinRegionTest()
    {
        ArrayList<Country> countryList = new ArrayList<Country>();
        countryList = app.getTopCountriesinRegion("Southern Europe", 4);
        assertEquals(countryList.get(0).getName(), "Italy");
        assertEquals(countryList.get(0).getRegion(), "Southern Europe");
        assertEquals(countryList.get(0).getPopulation(), 57680000);
    }

    //Test for getCountries
    @Test
    void getCountriesTest()
    {
        ArrayList<Country> countryList = new ArrayList<Country>();
        countryList = app.getCountries();
        assertEquals(countryList.get(0).getName(), "China");
        assertEquals(countryList.get(0).getContinent, "Asia");
        assertEquals(countryList.get(0).getPopulation, 1277558000);
    }

    //Test for getFiveLanguages()
    @Test
    void getFiveLanguagesTest()
    {
        ArrayList<CountryLanguage> langList = new ArrayList<CountryLanguage>();
        langList = app.getFiveLanguages();
        assertEquals(langList.get(0).getLanguage(), "Chinese");
        assertEquals(langList.get(0).getPopulation(), 1191843539);
        assertEquals(langList.get(0).getWorldPercentage(), "19.607%");
    }

    //Test for getAllCapitalCitiesByPopulation()
    @Test
    void getAllCapitalCitiesByPopulationTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getAllCapitalCitiesByPopulation();
        assertEquals(list.get(0).getName(), "Seoul");
        assertEquals(list.get(0).getCountry(), "South Korea");
        assertEquals(list.get(0).getPopulation(), 9981619);
    }

    //Test for getCapitalCitiesByPopulationInContinent("Europe")
    @Test
    void getCapitalCitiesByPopulationInContinentTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCapitalCitiesByPopulationInContinent("Europe");
        assertEquals(list.get(0).getName(), "Moscow");
        assertEquals(list.get(0).getCountry(), "Russian Federation");
        assertEquals(list.get(0).getPopulation(), 8389200);
    }

    //Test for getCapitalCitiesByPopulationInRegion("Caribbean")
    @Test
    void getCapitalCitiesByPopulationInRegionTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCapitalCitiesByPopulationInRegion("Caribbean");
        assertEquals(list.get(0).getName(), "La Habana");
        assertEquals(list.get(0).getCountry(), "Cuba");
        assertEquals(list.get(0).getPopulation(), 2256000);
    }

    //Test for getTopCapitalCitiesByPopulation(5)
    @Test
    void getTopCapitalCitiesByPopulationTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getTopCapitalCitiesByPopulation(5);
        assertEquals(list.get(0).getName(), "Seoul");
        assertEquals(list.get(0).getCountry(), "South Korea");
        assertEquals(list.get(0).getPopulation(), 9981619);
    }

    //Test for getCapitalCitiesByPopulationInContinent("Africa", 5)
    @Test
    void getCapitalCitiesByPopulationInContinentLimitedTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCapitalCitiesByPopulationInContinent("Africa",5);
        assertEquals(list.get(0).getName(), "Cairo");
        assertEquals(list.get(0).getCountry(), "Egypt");
        assertEquals(list.get(0).getPopulation(), 6789479);
    }

    //Test for getCapitalCitiesByPopulationInRegion("Middle East", 5)
    @Test
    void getCapitalCitiesByPopulationInRegionLimitedTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCapitalCitiesByPopulationInRegion("Middle East", 5);
        assertEquals(list.get(0).getName(), "Baghdad");
        assertEquals(list.get(0).getCountry(), "Iraq");
        assertEquals(list.get(0).getPopulation(), 4336000);
    }

}