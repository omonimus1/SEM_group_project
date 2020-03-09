package com.napier.sem;

public class Continent {
    private String name;
    private int population;
    private int cityPopulation;
    private int countrysidePopulation;
    private double percCityPopulation;
    private double percCountrysidePopulation;

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

    public double getPercCityPopulation() {
        return percCityPopulation;
    }

    public void setPercCityPopulation(double percCityPopulation) {
        this.percCityPopulation = percCityPopulation;
    }

    public double getPercCountrysidePopulation() {
        return percCountrysidePopulation;
    }

    public void setPercCountrysidePopulation(double percCountrysidePopulation) {
        this.percCountrysidePopulation = percCountrysidePopulation;
    }
}
