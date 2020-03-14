package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(langList[0].getLanguage(), "Chinese");
    }

    /*
    SIMONE'S GETCOUNTRY
    @Test
    void testGetCountry() {
        Country cnt = new Country("Italy");
        assertEquals(cnt.getName(), "Italy");
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(cnt);
        app.printCountries(countries);
        assertEquals(cnt.getName(), "null");
        countries.add(cnt);
        app.printCountries(countries);
    }

     */
}