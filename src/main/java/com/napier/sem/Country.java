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
    1)All the countries in the world organised by largest population to smallest.
    SELECT Name
    FROM country
    ORDER BY Population DESC;
}
