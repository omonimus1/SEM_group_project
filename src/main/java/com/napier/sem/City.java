package com.napier.sem;

/**
 * Authors: Davide Pollicino, Magdalena Calkova, Simona Georgieva, Simone Piazzini
 * COURSE: Software Engineering Methods (SET08103)
 * Last Modified: 20/02/2020
 * City Class that stores information about an instance of a city
 * It stores setters and getters that make the variables name, country, district and population accessible
 */

public class City {

    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;
    private String country;


    //Get and Set method for name
    public String getName()
    {
        return name;
    }
    public void setName(String new_name)
    {
        this.name=new_name;
    }

    //Get and Set method for country
    public String getCountry()
    {
        return country;
    }
    public void setCountry(String new_coun)
    {
        this.country=new_coun;
    }

    //Get and Set method for district
    public String getDistrict()
    {
        return district;
    }
    public void setDistrict(String new_dis)
    {
        this.district=new_dis;
    }

    //Get and Set method for population
    public int getPopulation()
    {
        return population;
    }
    public void setPopulation(int new_pop)
    {
        this.population=new_pop;
    }

}
