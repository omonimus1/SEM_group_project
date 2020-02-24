package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Authors: Davide Pollicino, Magdalena Calkova, Simona Georgieva, Simone Piazzini
 * COURSE: Software Engineering Methods (SET08103)
 * Last Modified: 10/02/2020
 * This application is designed for a company to retrieve information about countries related to their population, capital city, language etc.
 */

/*
 * Authors: Davide Pollicino, Magdalena Calkova, Simona Georgieva, Simone Piazzini
 * COURSE: Software Engineering Methods (SET08103)
 * Last Modified: 10/02/2020
 * This application is designed for a company to retrieve information about countries related to their population, capital city, language etc.
 */

public class App {

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        //get all capital cities by population
        ArrayList<City>
        allCapCities = a.getCapitalCitiesByPopulationInRegion("Caribbean");
        a.printCapitalCities(allCapCities);

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

}
