package com.napier.sem;

/**
 * Authors: Davide Pollicino, Magdalena Calkova, Simona Georgieva, Simone Piazzini
 * COURSE: Software Engineering Methods (SET08103)
 * Last Modified: 20/02/2020
 * CountryLanguage Class that stores information about an instance of a CountryLanguage
 * It stores getters and setters that make the variables language, country and percentage accessible
 */

public class CountryLanguage {

    private String countryCode;
    private String language;
    private boolean isOfficial;
    private double percentage;
    private String country;

    //Get and Set method for language
    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String new_lan)
    {
        this.language=new_lan;
    }

    //Get and Set method for country
    public String getCountry()
    {
        return country;
    }
    public void setCode(String new_coun)
    {
        this.country=new_coun;
    }

    //Get and Set method for percentage
    public double getPercentage()
    {
        return percentage;
    }
    public void setCode(double new_per)
    {
        this.percentage=new_per;
    }


}
