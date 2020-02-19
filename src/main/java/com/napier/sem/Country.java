package com.napier.sem;

import java.sql.Statement;
import java.util.ArrayList;

public class Country {
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private float SurfaceArea;
    private int IndepYea;
    private int Population;
    private float LifeExpectancy;
    private float GNP;
    private float GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private int Capital ;
    private String Code2;


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
            String strSelect = "SELECT Name"
                    + "FROM country"
                    + "ORDER BY Population DESC;";

            // Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract Countries information
            ArrayList<Country> countryArrayList = new ArrayList<Country>();
            while(rset.next())
            {
                Country ctr = new Country();
                ctr.Name = rset.getString("Country.Name");
                countryArrayList.add(ctr);
            }
            return countryArrayList;
        }
        catch(Expetion e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country Names list");
            return null;
        }
    }

    /**
     * Prints a list of Countries with the
     * @param employees The list of employees to print.
     */
    public void printCountries1(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
        // Loop over all employees in the list
        for (Country emp : coun)
        {
            String emp_string =
                    String.format("%-10s ",
                            Name);
            System.out.println(emp_string);
        }
    }
}
