package com.napier.sem;

/**
 * Authors: Davide Pollicino, Magdalena Calkova, Simona Georgieva, Simone Piazzini
 * COURSE: Software Engineering Methods (SET08103)
 * Last Modified: 13/03/2020
 * Country Class that stores information about an instance of a country
 * It stores getters and setters that make the variables code, name, continent, region, population and capital accessible
 */
public class Country {

    private String code;
    private String name;
    private  String continent;
    private String region;
    private double surfaceArea;
    private int indepYear;
    private int population;
    private double lifeExpectancy;
    private  double  GNP;
    private double GNPOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private String capital;
    private String code2;
    private String language;
    private int cityPopulation;
    private int countrysidePopulation;
    private String percCityPopulation;
    private String percCountrysidePopulation;

    Country(){}

    Country(String name){

    }
    //Get and Set method for code
    public String getCode()
    {
        return code;
    }
    public void setCode(String new_code)
    {
        this.code=new_code;
    }

    //Get and Set method for name
    public String getName()
    {
        return name;
    }
    public void setName(String new_name)
    {
        this.name=new_name;
    }

    //Get and Set method for continent
    public String getContinent()
    {
        return continent;
    }
    public void setContinent(String new_con)
    {
        this.continent=new_con;
    }

    //Get and Set method for region
    public String getRegion()
    {
        return region;
    }
    public void setRegion(String new_reg)
    {
        this.region=new_reg;
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

    //Get and Set method for capital
    public String getCapital()
    {
        return capital;
    }
    public void setCapital(String new_cap)
    {
        this.capital=new_cap;
    }

    // Get and Set method for city population
    public int getCityPopulation()
    {
        return cityPopulation;
    }
    public void setCityPopulation(int new_cityPop)
    {
        this.cityPopulation=new_cityPop;
    }

    // Get and Set method for countryside Population
    public int getCountrysidePopulation() { return countrysidePopulation; }
    public void setCountrysidePopulation(int new_countPop) { this.countrysidePopulation=new_countPop; }

    public String getPercCityPopulation() { return percCityPopulation; }
    public void setPercCityPopulation(String new_percCityPopulation) { this.percCityPopulation=new_percCityPopulation; }

    public String getPercCountrysidePopulation() { return percCountrysidePopulation; }
    public void setPercCountrysidePopulation(String new_percCountrysidePopulation) { this.percCountrysidePopulation=new_percCountrysidePopulation; }
}
