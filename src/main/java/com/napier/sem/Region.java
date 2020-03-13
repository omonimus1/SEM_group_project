package com.napier.sem;

public class Region {
    private String name;
    private int population;
    private int cityPopulation;
    private int countrySidePopulation;
    private String percCityPopulation;
    private String percCountrysidePopulation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public int getCountrySidePopulation() {
        return countrySidePopulation;
    }

    public void setCountrySidePopulation(int countrySidePopulation) {
        this.countrySidePopulation = countrySidePopulation;
    }

    public String getPercCityPopulation() {
        return percCityPopulation;
    }

    public void setPercCityPopulation(String percCityPopulation) {
        this.percCityPopulation = percCityPopulation;
    }

    public String getPercCountrysidePopulation() {
        return percCountrysidePopulation;
    }

    public void setPercCountrysidePopulation(String percCountrysidePopulation) {
        this.percCountrysidePopulation = percCountrysidePopulation;
    }
}
