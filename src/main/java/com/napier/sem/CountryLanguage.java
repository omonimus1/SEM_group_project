package com.napier.sem;

/**
 * Authors: Davide Pollicino, Magdalena Calkova, Simona Georgieva, Simone Piazzini
 * COURSE: Software Engineering Methods (SET08103)
 * Last Modified: 29/02/2020
 * CountryLanguage Class that stores information about an instance of a CountryLanguage
 * It stores getters and setters that make the variables language, population(the number of people speaking the language) and worldPercentage(the percentage of people speaking the language of the world) accessible
 */

public class CountryLanguage {

    private String language;
    private int population;
    private String worldPercentage;

    //Get and Set method for language
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String new_lan)
    {
        this.language=new_lan;
    }

    //Get and Set method for population (the number of people speaking the language)
    public int getPopulation()
    {
        return population;
    }
    public void setPopulation(int new_pop)
    {
        this.population=new_pop;
    }

    //Get and Set method for worldPercentage
    public String getWorldPercentage()
    {
        return worldPercentage;
    }
    public void setWorldPercentage(String new_per)
    {
        this.worldPercentage=new_per;
    }


}