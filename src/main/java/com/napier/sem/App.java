package com.napier.sem;

import org.graalvm.compiler.asm.amd64.AMD64Assembler;

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

        Country c = new Country();

        // Connect to database
        a.connect();

        // Create List of Cities
        ArrayList<City> cityList = new ArrayList<City>();


        // Fot test purpose, make sure that the SQL actually works
        // Create List of Country
        ArrayList<Country> countryArrayList = c.getAllCountriesByLargestToSmallestPopulation();
        // Shold be > 0 to se that actually thee queries works
        System.out.println(countryArrayList.size());

        // Create List of CountryLanguages
//        ArrayList<CountryLanguage> countryLanguages = new ArrayList<CountryLanguage>();
        c.printCountries1(countryArrayList);
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
}
