package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

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

        // Fot test purpose, make sure that the SQL actually works
        // Create List of Country
        ArrayList<Country> countryArrayList = a.getAllCountriesByLargestToSmallestPopulation();

        // Should be > 0 to se that actually thee queries works
        System.out.println(countryArrayList.size());

        //Print countries
        a.printCountries1(countryArrayList);

        // Disconnect from database
        a.disconnect();
    }

    //Create a connection to MySQL database
    private Connection con = null;

     //Connect to the MySQL database.
    public void connect() {
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
                Thread.sleep(30000);
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


     //Disconnect from the MySQL database.
    public void disconnect() {
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
     * Gets all the current Countries in the word and its population
     * @return A list of all all countries and population, sorted by the Country with
     * the Highest Population to the smallest, or null if there is an error.
     */
    public ArrayList<Country> getAllCountriesByLargestToSmallestPopulation()
    {
        try {
            // Create an SQL Statement
            Statement stmt = con.createStatement();

            // Create String for SQL statement
            String strSelect = "SELECT country.Code , country.Name, country.Continent, country.Population "
                    + "FROM country "
                    + "ORDER BY Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Countries information
            ArrayList<Country> countryArrayList = new ArrayList<Country>();
            while(rset.next())
            {
                Country ctr = new Country();
                ctr.setCode(rset.getString("country.Code"));
                ctr.setName(rset.getString("country.Name"));
                ctr.setContinent(rset.getString("country.Continent"));
                ctr.setPopulation(rset.getInt("country.Population"));
                countryArrayList.add(ctr);
            }
            return countryArrayList;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country list");
            return null;
        }
    }

    /**
     * Prints a list of Countries with the
     * @param countries The list of employees to print.
     */
    public void printCountries1(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-50s %-20s %-8s", "Code", "Name", "Continent", "Population"));
        // Loop over all employees in the list
        for (Country ctr : countries)
        {
            String ctr_string =
                    String.format("%-10s %-50s %-20s %-8s",
                            ctr.getCode(), ctr.getName(), ctr.getContinent(), ctr.getPopulation());
            System.out.println(ctr_string);
        }
    }

}

