#USE CASE: 3 Produce a Report on the Population of all the Cities.
##CHARACTERISTIC INFORMATION
###Goal in Context
3. As a Data Analyst I want to receive reports on the population of the cities in the world, in a continent, in a region, in a country and in a district from the largest to the smallest so that I can check which are the most populated cities.

###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the continent, region, country, district. Database contains data of the cities for each field.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is produced.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

##MAIN SUCCESS SCENARIO
1.Organisation request information for a given field - world, continent, country, region, district - to organise all the cities from largest to smallest .
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of the cities for the given field organising them from largest to smallest.
4.Data Analyst provides report to the organisation.



##SCHEDULE
DUE DATE: Release 3.0