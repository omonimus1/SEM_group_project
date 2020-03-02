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

        String world_population = a.getPopulationOfTheWorld();
        System.out.println("Population of the world: " + world_population);
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
            System.out.println("Failed to get total world population");
            return "Error while Fetching Global Population";
        }
    }

    /**
     * getPopulationOfTheWorld()
     * @param  contient
     * @return the total population in a specific Continent
     * */
/*
    private int getPopulationOfAContinent(String continent)
    {

        int population = 0;
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT SUM(Population)" +
                    "FROM world;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract information from the SQL table and create instances of Cities to be put in the ArrayList and returned

            while(rset.next())
            {
                City city = new City();
                population = rset.getInt("city.Population");
            }
            return population;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of all the cities by population in the world");
            return 1;
        }
    }
*/
    /**
     * getPopulationOfTheWorld()
     * @param  country
     * @return the total population in a specific country
     * */
   /*
    private int getPopulationOfACountry (String country)
    {


    }
*/

    /**
     * getPopulationOfTheWorld()
     * @param  region
     * @return the total population in a specific region
     * */
    /*
    private int getPopulationOfRegion (String region)
    {
        int population = 0;

        returun population;
    }
*/
    /**
     * getPopulationOfTheWorld()
     * @param  district
     * @return the total population in a specific district
     * */
    /*
    private int getPopulationDistrict( String district)
    {
        int population = 0;

        returun population;

    }
    */

    /**
     * getPopulationOfTheWorld()
     * @param    city
     * @return the total population in a specific Continent
     * */
    /*
    private int getPopulationOfACity (String city)
    {
        int population = 0;

        returun population;
    }
*/


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
     * @param district string name of the district
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
    private void printCities(ArrayList<City> cities)
    {
        // Print header for the cities
        System.out.println(String.format("%-70s %-50s %-40s %-8s", "Name", "Country", "District", "Population"));

        // Loop over all cities in the list
        for (City city : cities)
        {
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
