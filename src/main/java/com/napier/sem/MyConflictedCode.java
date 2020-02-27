package com.napier.sem;

public class MyConflictedCode {

/**
    SELECT countrylanguage.Language,
    ROUND(SUM(country.Population * (countrylanguage.Percentage/100))) AS `People Speaking`,
    CONCAT(ROUND((SUM(country.Population * (countrylanguage.Percentage/100))/(SELECT SUM(country.Population) FROM country)) * 100,3),'%') AS `World Percantage`
    FROM countrylanguage JOIN country ON (countrylanguage.CountryCode = country.Code)
    WHERE countrylanguage.Language = 'English'
    OR countrylanguage.Language = 'Chinese'
    OR countrylanguage.Language = 'Hindi'
    OR countrylanguage.Language = 'Spanish'
    OR countrylanguage.Language = 'Arabic'
    GROUP BY countrylanguage.Language
    ORDER BY ROUND(SUM(country.Population * (countrylanguage.Percentage/100))) DESC;
 */



}
