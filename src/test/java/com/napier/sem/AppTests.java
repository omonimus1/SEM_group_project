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
 * AppTests is a unit testing class, that tests priting methods of the App
 */

public class AppTests {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printCountriesTestNull()
    {
        app.printCountries(null);
    }

    //Country list is empy
    @test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);

    }

    // Country contains null
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }



    // Test for printing a Country if the provided list contains a correct country
    @Test
    void printCountriesTest()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.setCode("ABW");
        country.setName("Aruba");
        country.setContinent("North America");
        country.setRegion("Caribbean");
        country.setPopulation(103000);
        country.setCapital(129);
        countries.add(country);
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

    //Test for printCapitalCities() if the provided list is NULL
    @Test
    void printCapitalCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapitalCities(cities);
    }
    //Test for printCapitalCities() if the provided list contains an empty city
    @Test
    void printCapitalCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCapitalCities(cities);
    }
    //Test for printCapitalCities() if the provided list contains a normal instance of a city
    @Test
    void printCapitalCitiesTest()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.setName("Old Town");
        city.setCountry("Countea");
        city.setDistrict("Distrack");
        city.setPopulation(10);
        cities.add(city);
        app.printCapitalCities(cities);
    }

    //Test for printFiveLanguages() if the provided list is NULL
    @Test
    void printFiveLanguagesTestEmpty()
    {
        ArrayList<CountryLanguage> counLangs = new ArrayList<CountryLanguage>();
        app.printFiveLanguages(counLangs);
    }
    //Test for printFiveLanguages() if the provided list contains an empty country language
    @Test
    void printFiveLanguagesTestContainsNull()
    {
        ArrayList<CountryLanguage> counLangs = new ArrayList<CountryLanguage>();
        counLangs.add(null);
        app.printFiveLanguages(counLangs);
    }
    //Test for printFiveLanguages() if the provided list contains a normal instance of a country language
    @Test
    void printFiveLanguagesTest()
    {
        ArrayList<CountryLanguage> counLangs = new ArrayList<CountryLanguage>();
        CountryLanguage lang = new CountryLanguage();
        lang.setLanguage("Old Tongue");
        lang.setWorldPercentage("0.000 %");
        lang.setPopulation(2);
        counLangs.add(lang);
        app.printFiveLanguages(counLangs);
    }
}