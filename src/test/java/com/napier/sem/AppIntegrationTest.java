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

    //Test for getWorldCitiesByPopulation()
    @Test
    void getWorldCitiesByPopulationTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getWorldCitiesByPopulation();
        assertEquals(list.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(list.get(0).getCountry(), "India");
        assertEquals(list.get(0).getDistrict(), "KMaharashtra");
        assertEquals(list.get(0).getPopulation(), 10500000);
    }

    //Test for getCitiesByPopulationInContinent("Europe")
    @Test
    void getCitiesByPopulationInContinentTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCitiesByPopulationInContinent("Europe");
        assertEquals(list.get(0).getName(), "Barcelona");
        assertEquals(list.get(0).getCountry(), "Spain");
        assertEquals(list.get(0).getDistrict(), "Katalonia");
        assertEquals(list.get(0).getPopulation(), 1503451);
    }

    //Test for getCitiesByPopulationInRegion("Western Europe")
    @Test
    void getCitiesByPopulationInRegionTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCapitalCitiesByPopulationInRegion("Western Europe");
        assertEquals(list.get(0).getName(), "Brugge");
        assertEquals(list.get(0).getCountry(), "Belgium");
        assertEquals(list.get(0).getDistrict(), "West Flanderi");
        assertEquals(list.get(0).getPopulation(), 116246);
    }

    //Test for getCitiesByPopulationInCountry("Albania")
    @Test
    void getCitiesByPopulationInCountryTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCitiesByPopulationInCountry("Albania");
        assertEquals(list.get(0).getName(), "Tirana");
        assertEquals(list.get(0).getCountry(), "Albania");
        assertEquals(list.get(0).getDistrict(), "Tirana");
        assertEquals(list.get(0).getPopulation(), 270000);
    }

    //Test for getCitiesByPopulationInDistrict("Noord-Brabant")
    @Test
    void getCitiesByPopulationInDistrictTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCitiesByPopulationInDistrict("Noord-Brabant");
        assertEquals(list.get(0).getName(), "Tilburg");
        assertEquals(list.get(0).getCountry(), "Netherlands");
        assertEquals(list.get(0).getDistrict(), "Noord-Brabant");
        assertEquals(list.get(0).getPopulation(), 193238);
    }

    //Test for getTopCitiesByPopulation(5)
    @Test
    void getTopCitiesByPopulationTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getTopCitiesByPopulation(5);
        assertEquals(list.get(0).getName(), "Amsterdam");
        assertEquals(list.get(0).getCountry(), "Netherlands");
        assertEquals(list.get(0).getDistrict(), "Noord-Holland");
        assertEquals(list.get(0).getPopulation(), 731200);
    }

    //Test for getCitiesByPopulationInContinent("Asia", 5)
    @Test
    void getCitiesByPopulationInContinentLimitedTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCitiesByPopulationInContinent("Asia",5);
        assertEquals(list.get(0).getName(), "Mumbai (Bombay)");
        assertEquals(list.get(0).getCountry(), "United Arab Emirates");
        assertEquals(list.get(0).getDistrict(), "Abu Dhabi");
        assertEquals(list.get(0).getPopulation(), 398695);
    }

    //Test for getCitiesByPopulationInRegion("Western Europe", 5)
    @Test
    void getCitiesByPopulationInRegionLimitedTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCitiesByPopulationInRegion("Western Europe");
        assertEquals(list.get(0).getName(), "Brugge");
        assertEquals(list.get(0).getCountry(), "Belgium");
        assertEquals(list.get(0).getDistrict(), "West Flanderi");
        assertEquals(list.get(0).getPopulation(), 116246);
    }

    //Test for getCitiesByPopulationInCountry("Albania", 5)
    @Test
    void getCitiesByPopulationInCountryLimitedTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCitiesByPopulationInCountry("Albania", 5);
        assertEquals(list.get(0).getName(), "Tirana");
        assertEquals(list.get(0).getCountry(), "Albania");
        assertEquals(list.get(0).getDistrict(), "Tirana");
        assertEquals(list.get(0).getPopulation(), 270000);
    }

    //Test for getCitiesByPopulationInDistrict("Noord-Brabant", 5)
    @Test
    void getCitiesByPopulationInDistrictLimitedTest()
    {
        ArrayList<City> list = new ArrayList<City>();
        list = app.getCitiesByPopulationInDistrict("Noord-Brabant", 5);
        assertEquals(list.get(0).getName(), "Eindhoven");
        assertEquals(list.get(0).getCountry(), "Netherlands");
        assertEquals(list.get(0).getDistrict(), "Noord-Brabant");
        assertEquals(list.get(0).getPopulation(), 193238);
    }

}