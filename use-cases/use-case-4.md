#USE CASE: 4 Produce a Report on the Population for a specific number of cities.
##CHARACTERISTIC INFORMATION
###Goal in Context
4. As a Data Analyst I want to receive a report on the population of a specific number of cities in the world, provided by me, so that I can make a statistic for the movement of the population in the world, or in a particular continent, region, country, district.

###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the continent, region, country, district and the number of top populated cities to be searched. Database contains data of the cities for each field.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is produced.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

##MAIN SUCCESS SCENARIO
1.Organisation request information for a given field - world, continent, country, region, district - to find the top N populated cities, where N is given by organisation.
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of the cities for the given field selecting the top N populated cities.
4.Data Analyst provides report to the organisation.



##SCHEDULE
DUE DATE: Release 3.0