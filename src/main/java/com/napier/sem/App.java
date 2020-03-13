package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Authors: Davide Pollicino, Magdalena Calkova, Simona Georgieva, Simone Piazzini
 * COURSE: Software Engineering Methods (SET08103)
 * Last Modified: 29/02/2020
 * This application is designed for a company to retrieve information about countries related to their population, capital city, language etc.
 */

public class App {

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        ArrayList<CountryLanguage> clList = new ArrayList<CountryLanguage>();
        clList=a.getFiveLanguages();
        a.printFiveLanguages(clList);

        // Method testing
        String world_population = a.getPopulationOfTheWorld();
        String continent_population = a.getPopulationOfAContinent("Oceania");
        String country_population = a.getPopulationOfACountry("Italy");
        String city_population = a.getPopulationOfACity("Roma");
        String district_population = a.getPopulationDistrict("Texas");
        String region_population = a.getPopulationOfRegion("South America");

        // Printing Result of the tests
        System.out.println("Population of the world: " + world_population);
        System.out.println("Population of the Continent Ocenaia : " + continent_population);
        System.out.println("Population of the country Italy: " + country_population);
        System.out.println("Population of the city Roma: " + city_population);
        System.out.println("Population of the District California: " + district_population);
        System.out.println("Population of the Region South America: " + region_population);


        // Disconnect from database
        a.disconnect();

    }

    /** con: Instance of the Connection object*/
    private Connection con = null;

    /** Connect(): Open the connection with the SQL Database
      */
    private void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("The SQL driver couldn't be loaded...");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(3000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Connection was a success!");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to the database. (Attempt: " + Integer.toString(i) + ")" );
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted...");
            }
        }
    }

    /**
     * disconnect():  Close the connection to the SQL Databse
     * */
    //Disconnect from the MySQL database.
    private void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("ERORR: During closing of the connection to the database");
            }
        }
    }
    /* Get all the countries in the world retrieved from the Database organised by largest population to smallest*/
    private ArrayList<Country> getCountries()
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "ORDER BY Population DESC; ";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Country> countryList = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setCapital(rset.getString("country.Capital"));
                countryList.add(country);
            }
            return countryList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the world");
            return null;
        }
    }

    /* Generate report for a given number
    * of countries
    * */
    private ArrayList<Country> getTopCountries(int n)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT Name " +
                    "FROM country " +
                    "ORDER BY Population DESC; "
                    + "LIMIT " + n + " ;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Country> countryList = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.setName(rset.getString("country.Name"));
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setCapital(rset.getString("country.Capital"));

                countryList.add(country);
            }
            return countryList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the world");
            return null;
        }
    }

    /*
     * Generate a report for all the countries in a given continent organised by largest to smallest
     *
     *
     * */
    private ArrayList<Country> getCountriesinContinent(String continent)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "WHERE continent = " + continent  +
                    " ORDER BY Population DESC; ";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Country> countryList = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setCapital(rset.getString("country.Capital"));
                countryList.add(country);
            }
            return countryList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the world");
            return null;
        }
    }

    /*
     *  Generate report of top 'n' populated countries provided by the user
     *
     * */
    private ArrayList<Country> getTopCountriesinContinent(String continent, int n)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT Name " +
                    "FROM country " +
                    "WHERE continent = " + continent +
                    " ORDER BY Population DESC "
                    + " LIMIT BY " + n + " ;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Country> countryList = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setCapital(rset.getString("country.Capital"));
                countryList.add(country);
            }
            return countryList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the world");
            return null;
        }
    }


    private ArrayList<Country> getCountriesinRegion(String region)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital " +
                    "FROM country " +
                    "WHERE region =" + region +
                    " ORDER BY Population DESC; ";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Country> countryList = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setCapital(rset.getString("country.Capital"));
                countryList.add(country);
            }
            return countryList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the world");
            return null;
        }
    }


    private ArrayList<Country> getTopCountriesinRegion(String region, int n)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT Name " +
                    "FROM country " + region +
                    " ORDER BY Population DESC "
                    + " LIMIT " + n + " ;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Country> countryList = new ArrayList<Country>();
            while(rset.next())
            {
                Country country = new Country();
                country.setCode(rset.getString("country.Code"));
                country.setName(rset.getString("country.Name"));
                country.setContinent(rset.getString("country.Continent"));
                country.setRegion(rset.getString("country.Region"));
                country.setPopulation(rset.getInt("country.Population"));
                country.setCapital(rset.getString("country.Capital"));
                countryList.add(country);
            }
            return countryList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the world");
            return null;
        }
    }

    /**
     * Prints a list of capital cities
     * @paramt capCities The list of capital cities to print
     */
    public void printCountries(ArrayList<Country> countries)
    {
        //Check countries is not null
        if(countries == null){
            System.out.println("No countries");
            return;
        }
        // Print header for the capital cities
        System.out.println(String.format("%-5s %-50s %-20s %-50s %-8s %-30s", "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Loop over all capital cities in the list
        for (Country country : countries)
        {
            if(country == null)
                continue;
            String countries_string =
                    String.format("%-5s %-50s %-20s %-50s %-8s %-30s",
                            country.getCode(), country.getName(), country.getContinent(), country.getRegion(),  country.getPopulation(), country.getCapital());
            System.out.println(countries_string);
        }
    }
    /**
     * getPopulationOfTheWorld()
     * @return the total world population
     * */
    private String getPopulationOfTheWorld()
    {
        String population = "";
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect =  "SELECT SUM(Population) " +
                    "FROM country;";


            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned

            while(rset.next())
            {
                Country country = new Country();
                 population = (rset.getString("SUM(Population)"));
            }
            return population;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return "Error while Fetching Global Population";
        }
    }

    /**
     * getPopulationOfTheWorld()
     * @param  continent
     * @return the total population in a specific Continent
     * */

    private String getPopulationOfAContinent(String continent)
    {
        System.out.println("Starting continent function");
        String population = "";
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();
            System.out.print("INSIDE TRY");
            // Create String for SQL statement
            // @output should be 30401150
            String strSelect =  "SELECT SUM(Population) " +
                    " FROM country " +
                    " WHERE Continent = '" + continent + "';";

            System.out.println(strSelect);
            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned

            while(rset.next())
            {
                Country country = new Country();
                population = (rset.getString("SUM(Population)"));
            }
            return population;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return "Error while Fetching Population Present in the " + continent + " continent;";
        }
    }

    /**
     * getPopulationOfTheWorld()
     * @param  country
     * @return the total population in a specific country
     * */

    private String getPopulationOfACountry(String country)
    {
        String population = "";
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            // @output should be 57680000
            String strSelect =  "SELECT Population" +
                    " FROM country " +
                    " WHERE Name = '" +
                    country + "';";


            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned

            while(rset.next())
            {
                population = (rset.getString("Population"));
            }
            return population;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return "Error while Fetching Population of the Country: " + country;
        }
    }


    /**
     * getPopulationOfTheWorld()
     * @param  region
     * @return the total population in a specific region
     * */
    private String getPopulationOfRegion (String region)
    {
        String population = "";
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            // @output should be 345780000
            String strSelect =  "SELECT SUM(Population) " +
                    "FROM country " +
                    "WHERE Region =  '" +
                     region + "';";
            System.out.println(strSelect);
            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned

            population = (rset.getString("SUM(Population)"));
            return population;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return "Error while fetching the Population living the Region : " + region;
        }
    }

    /**
     * getPopulationOfTheWorld()

     * @return the total population in a specific district
     * */
    private String getPopulationDistrict(String district)
    {
        String population = "";
        System.out.println("Starting district function");
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();
            System.out.println("Insert district function");
            // Create String for SQL statement
            //@ output should be 16716706
            String strSelect =  "SELECT SUM(Population)" +
                    " FROM city " +
                    " WHERE District = '" +
                     district + "';";

            System.out.println("Query for District Population: " + strSelect);
            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            population = (rset.getString("SUM(Population)"));

            return population;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return "Error while fetching the Population living the District Texas:" ;
        }
    }


    /**
     * getPopulationOfTheWorld()
     * @param    city
     * @return the total population in a specific Continent
     * */

    private String getPopulationOfACity (String city)
    {
        String population = "";
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect =  "SELECT Population" +
                    " FROM city " +
                    " WHERE Name = '" + city + "';";


            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned

            while(rset.next())
            {
                Country country = new Country();
                population = (rset.getString("Population"));
            }
            return population;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return "Error while fetching the Population living the city : " + city;
        }
    }



    /**
     * Gets all cities in the world ordered by population from the largest to the smallest
     * @return A list of all cities with their country and population
     */
    private ArrayList<City> getWorldCitiesByPopulation()
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "ORDER BY city.Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the world");
            return null;
        }
    }

    /**
     * Gets x cities in the world ordered by population from the largest, where x is specified by the user
     * @param amount The number of cities to produce
     * @return A list of x amount of cities
     */
    private ArrayList<City> getTopCitiesByPopulation(int amount) {
        try
        {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "ORDER BY city.Population DESC "
                    + "LIMIT " + amount + " ;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while (rset.next()) {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of top " + amount + " cities by population in the world");
            return null;
        }
    }

    /**
     * Gets all cities in the specified continent by population from the largest to the smallest
     * @param continent string name of the continent
     * @return A list of all cities in the continent
     */
    private ArrayList<City> getCitiesByPopulationInContinent(String continent)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Continent = '" + continent
                    + "' ORDER BY city.Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the continent");
            return null;
        }
    }

    /**
     * Gets x cities in the specified continent, where x is provided by the user
     * @param continent The string name of the continent
     * @param amount The number of cities to produce
     * @return A list of x amount of cities in the continent
     */
    private ArrayList<City> getCitiesByPopulationInContinent(String continent, int amount)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Continent = '" + continent
                    + "' ORDER BY city.Population DESC "
                    + "LIMIT " + amount + ";";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of top "+ amount +" cities by population in the continent");
            return null;
        }
    }

    /**
     * Gets all cities in the specified region by population from largest to smallest
     * @param region string name of the region
     * @return A list of all cities in the region
     */
    private ArrayList<City> getCitiesByPopulationInRegion(String region)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Region = '" + region
                    + "' ORDER BY city.Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                System.out.println("City example:"+ city.getName());
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the region");
            return null;
        }
    }

    /**
     * Gets x cities in the specified region, where x is provided by the user
     * @param region The string name of the region
     * @param amount The number of cities to produce
     * @return A list of x amount of cities in the region
     */
    private ArrayList<City> getCitiesByPopulationInRegion(String region, int amount)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Region = '" + region
                    + "' ORDER BY city.Population DESC "
                    + "LIMIT " + amount + ";";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of top "+ amount +" cities by population in the region");
            return null;
        }
    }

    /**
     * Gets all cities in the specified country by population from largest to smallest
     * @param country string name of the country
     * @return A list of all cities in the country
     */
    private ArrayList<City> getCitiesByPopulationInCountry(String country)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Name = '" + country
                    + "' ORDER BY city.Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the country");
            return null;
        }
    }

    /**
     * Gets x cities in the specified country, where x is provided by the user
     * @param country The string name of the country
     * @param amount The number of cities to produce
     * @return A list of x amount of cities in the country
     */
    private ArrayList<City> getCitiesByPopulationInCountry(String country, int amount)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Name = '" + country
                    + "' ORDER BY city.Population DESC "
                    + "LIMIT " + amount + ";";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of top "+ amount +" cities by population in the country");
            return null;
        }
    }

    /**
     * Gets all cities in the specified district by population from largest to smallest
     * @return A list of all cities in the district
     */
    private ArrayList<City> getCitiesByPopulationInDistrict(String district)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE city.District = '" + district
                    + "' ORDER BY city.Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the district");
            return null;
        }
    }

    /**
     * Gets x cities in the specified district, where x is provided by the user
     * @param district The string name of the district
     * @param amount The number of cities to produce
     * @return A list of x amount of cities in the district
     */
    private ArrayList<City> getCitiesByPopulationInDistrict(String district, int amount)
    {
        try
        {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.District, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE city.District = '" + district
                    + "' ORDER BY city.Population DESC "
                    + "LIMIT " + amount + ";";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> cityList = new ArrayList<City>();
            while(rset.next())
            {
                City city = new City();
                city.setName(rset.getString("city.Name"));
                city.setCountry(rset.getString("country.Name"));
                city.setDistrict(rset.getString("city.District"));
                city.setPopulation(rset.getInt("city.Population"));
                cityList.add(city);
            }
            return cityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of top "+ amount +" cities by population in the district");
            return null;
        }
    }

    /**
     * Prints a list of cities
     * @paramt cities The list of cities to print
     */
    public void printCities(ArrayList<City> cities)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header for the cities
        System.out.println(String.format("%-70s %-50s %-40s %-8s", "Name", "Country", "District", "Population"));

        // Loop over all cities in the list
        for (City city : cities)
        {
            if (city == null)
                continue;
            String city_string =
                    String.format("%-70s %-50s %-40s %-8s",
                            city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
            System.out.println(city_string);
        }
    }

    /**
     * Gets all the capital cities in teh world ordered by population from the largest
     * @return A list of all capital cities with their country and population
     */
    private ArrayList<City> getAllCapitalCitiesByPopulation()
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Capital = city.ID "
                    + "ORDER BY city.Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> capCityList = new ArrayList<City>();
            while(rset.next())
            {
                City cap = new City();
                cap.setName(rset.getString("city.Name"));
                cap.setCountry(rset.getString("country.Name"));
                cap.setPopulation(rset.getInt("city.Population"));
                capCityList.add(cap);
            }
            return capCityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of all capital cities by population");
            return null;
        }
    }

    /**
     * Gets x capital cities in teh world ordered by population from the largest, where x is specified by the user
     * @param amount The number of capital cities to produce
     * @return A list of x amount of capital cities with their country and population
     */
    private ArrayList<City> getTopCapitalCitiesByPopulation(int amount) {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Capital = city.ID "
                    + "ORDER BY city.Population DESC "
                    + "LIMIT " + amount + " ;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> capCityList = new ArrayList<City>();
            while (rset.next()) {
                City cap = new City();
                cap.setName(rset.getString("city.Name"));
                cap.setCountry(rset.getString("country.Name"));
                cap.setPopulation(rset.getInt("city.Population"));
                capCityList.add(cap);
            }
            return capCityList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of " + amount + " capital cities by population");
            return null;
        }
    }

    /**
     * Gets all capital cities in the specified continent
     * @param continent string name of the continent
     * @return A list of all capital cities in the continent
     */
    private ArrayList<City> getCapitalCitiesByPopulationInContinent(String continent)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Capital = city.ID "
                    + "AND country.Continent = '" + continent
                    + "' ORDER BY city.Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> capCityList = new ArrayList<City>();
            while(rset.next())
            {
                City cap = new City();
                cap.setName(rset.getString("city.Name"));
                cap.setCountry(rset.getString("country.Name"));
                cap.setPopulation(rset.getInt("city.Population"));
                capCityList.add(cap);
            }
            return capCityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of capital cities by population in the continent");
            return null;
        }
    }

    /**
     * Gets x capital cities in the specified continent, where x is provided by the user
     * @param continent The string name of the continent
     * @param amount The number of capital cities to produce
     * @return A list of x amount of capital cities in the continent
     */
    private ArrayList<City> getCapitalCitiesByPopulationInContinent(String continent, int amount)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Capital = city.ID "
                    + "AND country.Continent = '" + continent
                    + "' ORDER BY city.Population DESC "
                    + "LIMIT " + amount + ";";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> capCityList = new ArrayList<City>();
            while(rset.next())
            {
                City cap = new City();
                cap.setName(rset.getString("city.Name"));
                cap.setCountry(rset.getString("country.Name"));
                cap.setPopulation(rset.getInt("city.Population"));
                capCityList.add(cap);
            }
            return capCityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of "+ amount +" capital cities by population in the continent");
            return null;
        }
    }

    /**
     * Gets all capital cities in the specified region
     * @param region string name of the region
     * @return A list of all capital cities in the region
     */
    private ArrayList<City> getCapitalCitiesByPopulationInRegion(String region)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Capital = city.ID "
                    + "AND country.Region = '" + region
                    + "' ORDER BY city.Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> capCityList = new ArrayList<City>();
            while(rset.next())
            {
                City cap = new City();
                cap.setName(rset.getString("city.Name"));
                cap.setCountry(rset.getString("country.Name"));
                cap.setPopulation(rset.getInt("city.Population"));
                capCityList.add(cap);
            }
            return capCityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of capital cities by population in the region");
            return null;
        }
    }

    /**
     * Gets x capital cities in the specified region, where x is provided by the user
     * @param region The string name of the region
     * @param amount The number of capital cities to produce
     * @return A list of all capital cities in the region
     */
    private ArrayList<City> getCapitalCitiesByPopulationInRegion(String region, int amount)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT city.Name, country.Name, city.Population "
                    + "FROM city JOIN country ON (city.CountryCode=country.Code) "
                    + "WHERE country.Capital = city.ID "
                    + "AND country.Region = '" + region
                    + "' ORDER BY city.Population DESC "
                    + "LIMIT " + amount + ";";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<City> capCityList = new ArrayList<City>();
            while(rset.next())
            {
                City cap = new City();
                cap.setName(rset.getString("city.Name"));
                cap.setCountry(rset.getString("country.Name"));
                cap.setPopulation(rset.getInt("city.Population"));
                capCityList.add(cap);
            }
            return capCityList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get list of  "+ amount +" capital cities by population in the region");
            return null;
        }
    }

    /**
     * Prints a list of capital cities
     * @paramt capCities The list of capital cities to print
     */
    private void printCapitalCities(ArrayList<City> capCities)
    {
        // Print header for the capital cities
        System.out.println(String.format("%-60s %-50s %-8s", "Name", "Country", "Population"));

        // Loop over all capital cities in the list
        for (City capCity : capCities)
        {
            String capCity_string =
                    String.format("%-60s %-50s %-8s",
                            capCity.getName(), capCity.getCountry(), capCity.getPopulation());
            System.out.println(capCity_string);
        }
    }
    /**
    Get the population of people living in cities and people not living in cities
     * in each continent
     * @return ArrayList of Continent, the amount of people living and cities and not living in the cities
     */

    public ArrayList<Continent> getPopulationInCitiesAndNotInCitiesContinent(String continent)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            /**
            * ********* Missing Tot population of continent ********
            * */

            // Create String for SQL statement
            String strSelect = "SELECT country.Continent, country.Population, "
                    + "SUM(city.Population) AS `People Living In Cities`," + " (country.Population - SUM(city.Population)) AS `People Not Living In cities`,\n" +
                    "CONCAT(ROUND(SUM(city.Population)/country.Population * 100, 2),'%') AS `City Living Perc`,\n" +
                    "CONCAT(ROUND((country.Population - SUM(city.Population))/country.Population * 100, 2),'%') AS `Not Living In Cities Perc`\n" +
                    "FROM country JOIN city ON (country.Code = city.CountryCode)\n" +
                    "WHERE continent= " + continent +
                    " GROUP BY country.Name, country.Population; ";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Continent> populationInCitiesAndNotInCitiesContinent = new ArrayList<Continent>();
            while(rset.next())
            {
                Continent cont = new Continent();
                cont.setName(rset.getString("country.Continent"));
                cont.setPopulation(rset.getInt(""));
                cont.setPercCityPopulation(rset.getString(""));
                cont.setPercCountrysidePopulation(rset.getString(""));
                populationInCitiesAndNotInCitiesContinent.add(cont);
            }
            return populationInCitiesAndNotInCitiesContinent;

    } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error getting a list with the people living and not living in cities in each continent");
            return null;
        }
    }

    /**
     * Prints the name, population, city population, country population and their percentages stored in the supplied list
     * @param populationListOfPeople
     */
    private void printPopulationLivingInCitiesOrNotLivingInCities(ArrayList<Continent> populationListOfPeople)
    {
        // Print header for the capital cities
        System.out.println(String.format("%-20s %-15s %-8s %-8s", "Name", "Population", "City Population", "Country Population"));

        // Loop over all capital cities in the list
        for (Continent cont : populationListOfPeople)
        {
            String population_string =
                    String.format("%-20s %-15s %-8s %-8s",
                            cont.getName(), cont.getPopulation(), cont.getPercCityPopulation(), cont.getPercCountrysidePopulation());
            System.out.println(population_string);
        }
    }

    /**
     Get the population of people living in cities and people not living in cities
     * in each region
     * @return ArrayList of Region, the amount of people living and cities and not living in the cities
     */
    public ArrayList<Region> getPopulationInCitiesAndNotInCitiesRegion(String region)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            /**
             ****** Missing Tot Poppulation in region *******
             * */

            // Create String for SQL statement
            String strSelect = "SELECT region.Name, country.Population, "
                    + "SUM(city.Population) AS `People Living In Cities`," + " (country.Population - SUM(city.Population)) AS `People Not Living In cities`,\n" +
                    "CONCAT(ROUND(SUM(city.Population)/country.Population * 100, 2),'%') AS `City Living Perc`,\n" +
                    "CONCAT(ROUND((country.Population - SUM(city.Population))/country.Population * 100, 2),'%') AS `Not Living In Cities Perc`\n" +
                    "FROM country JOIN city ON (country.Code = city.CountryCode)\n" +
                    "WHERE region= " + region +
                    " GROUP BY country.Name, country.Population; ";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Region> populationInCitiesAndNotInCitiesRegion = new ArrayList<Region>();
            while(rset.next())
            {
                Region reg = new Region();
                reg.setName(rset.getString("region.Region"));
                reg.setPopulation(rset.getInt("country.Population"));
                reg.setPercCityPopulation(rset.getString("City Living Perc"));
                reg.setPercCountrysidePopulation(rset.getString("Not Living In Cities Perc"));
                populationInCitiesAndNotInCitiesRegion.add(reg);
            }
            return populationInCitiesAndNotInCitiesRegion;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error getting a list with the people living and not living in cities in each region");
            return null;
        }
    }




    /**
     Get the population of people living in cities and people not living in cities
     * in each country
     * @return ArrayList of Country, the amount of people living and cities and not living in the cities
     */
    public ArrayList<Country> getPopulationInCitiesAndNotInCitiesCountry(String country)
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT country.Name, country.Population, "
                    + "SUM(city.Population) AS `People Living In Cities`," + " (country.Population - SUM(city.Population)) AS `People Not Living In cities`,\n" +
                    "CONCAT(ROUND(SUM(city.Population)/country.Population * 100, 2),'%') AS `City Living Perc`,\n" +
                    "CONCAT(ROUND((country.Population - SUM(city.Population))/country.Population * 100, 2),'%') AS `Not Living In Cities Perc`\n" +
                    "FROM country JOIN city ON (country.Code = city.CountryCode)\n" +
                    "WHERE country= " + country +
                    " GROUP BY country.Name, country.Population; ";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<Country> populationInCitiesAndNotInCitiesCountry = new ArrayList<Country>();
            while(rset.next())
            {
                Country count = new Country();
                count.setName(rset.getString("country.Name"));
                count.setPopulation(rset.getInt("People Living In Cities"));
                count.setPercCityPopulation(rset.getString("City Living Perc"));
                count.setPercCountrysidePopulation(rset.getString("Not Living In Cities Perc"));
                populationInCitiesAndNotInCitiesCountry.add(count);
            }
            return populationInCitiesAndNotInCitiesCountry;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error getting a list with the people living and not living in cities in each country");
            return null;
        }
    }
    /**
     * Prints the name, population, city population, country population and their percentages stored in the supplied list
     * @param populationListOfPeople

     ****** To be checked *****

     */

    private void printPopulationLivingInCitiesOrNotLivingInCitiesForCountry(ArrayList<Country> populationListOfPeople)
    {
        // Print header for the capital cities
        System.out.println(String.format("%-20s %-15s %-8s %-8s", "Name", "Population", "City Population", "Country Population"));

        // Loop over all capital cities in the list
        for (Country country : populationListOfPeople)
        {
            String population_string =
                    String.format("%-20s %-15s %-8s %-8s",
                            country.getName(), country.getPopulation(), country.getPercCityPopulation(), country.getPercCountrysidePopulation());
            System.out.println(population_string);
        }
    }

        /**
     * Gets the number of people speaking and the world percentage of English, Chinese, Spanish, Hindi and Arabic
     * @return ArrayList of CountryLanguages of English, Chinese, Spanish, Hindi and Arabic
     */
    private ArrayList<CountryLanguage> getFiveLanguages()
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String getQuery =
                    "SELECT countrylanguage.Language, "
                            + "ROUND(SUM(country.Population * (countrylanguage.Percentage/100))) AS `People Speaking`, "
                            + "CONCAT(ROUND((SUM(country.Population * (countrylanguage.Percentage/100))/(SELECT SUM(country.Population) FROM country)) * 100,3),'%') AS `World Percantage` "
                            + "FROM countrylanguage JOIN country ON (countrylanguage.CountryCode = country.Code)"
                            + "WHERE countrylanguage.Language = 'English' "
                            + "OR countrylanguage.Language = 'Chinese' "
                            + "OR countrylanguage.Language = 'Hindi' "
                            + "OR countrylanguage.Language = 'Spanish' "
                            + "OR countrylanguage.Language = 'Arabic' "
                            + "GROUP BY countrylanguage.Language "
                            + "ORDER BY ROUND(SUM(country.Population * (countrylanguage.Percentage/100))) DESC;";
            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(getQuery);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned
            ArrayList<CountryLanguage> languageList = new ArrayList<CountryLanguage>();
            while(rset.next())
            {
                CountryLanguage lan = new CountryLanguage();
                lan.setLanguage(rset.getString("countrylanguage.Language"));
                lan.setPopulation(rset.getInt("People Speaking"));
                lan.setWorldPercentage(rset.getString("World Percantage"));
                languageList.add(lan);

            }
            return languageList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Error while getting the populations of the 5 specified languages");
            return null;
        }
    }


    /**
     * Prints the name, number of people speaking and the world percentage of CountryLanguages stored in the supplied list
     * @param languageList the list of CountryLanguage to display contents of
     */
    private void printFiveLanguages(ArrayList<CountryLanguage> languageList)
    {
        // Print header for the capital cities
        System.out.println(String.format("%-20s %-15s %-8s", "Language", "Population", "World Percentage"));

        // Loop over all capital cities in the list
        for (CountryLanguage cl : languageList)
        {
            String language_string =
                    String.format("%-20s %-15s %-8s",
                            cl.getLanguage(), cl.getPopulation(), cl.getWorldPercentage());
            System.out.println(language_string);
        }
    }

}
