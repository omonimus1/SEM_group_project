package com.napier.sem;

public class Continent {
    private String name;
    private int population;
    private int cityPopulation;
    private int countrysidePopulation;
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

    public int getCountrysidePopulation() {
        return countrysidePopulation;
    }

    public void setCountrysidePopulation(int countrysidePopulation) {
        this.countrysidePopulation = countrysidePopulation;
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
