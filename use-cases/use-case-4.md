#USE CASE: 4 Generate a Report on the Top X Populated Cities.
##CHARACTERISTIC INFORMATION
###Goal in Context
As a *Data Analyst* I want to *generate a report on the top X populated cities in the world, in a continent, in a region, in a country and in a district, where X is a number provided by me*, so that *a statistic for the movement of the population in the specified area can be made*.
###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the continent, region, country, district and the number of top populated cities to be searched. Database contains data of the cities for each field.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is generated.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

###MAIN SUCCESS SCENARIO
1.Organisation requests information for a given field - world, continent, country, region, district - to find the top N populated cities, where N is given by organisation.
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of the cities for the given field selecting the top N populated cities.
4.Data Analyst provides report to the organisation.

###EXTENSIONS
Field does not exist:
Data analyst informs the organisation that a field has not been filled yet.

###SUB-VARIATIONS
None

###SCHEDULE
DUE DATE: Release 2.0