#USE CASE: 2 Produce a Report on the top populated countries
##CHARACTERISTIC INFORMATION
###Goal in Context
2. As a Data Analyst I want to receive reports on the population of a specific number of populated countries in the world, in a continent and in a region, provided by me, so that I can make a statistic for the movement of the population.

###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the number of top populated countries to be searched. Database contains data for world, continent and region.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is produced.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

##MAIN SUCCESS SCENARIO
1.Organisation request information for a given field - country, continent, regions requesting the top N populated countries.
2.Data Analyst searches the top N populated countries, given by the organisation.
3.Data Analyst extracts data of the population for the given field and top countries.
4.Data Analyst provides report to the organisation.



##SCHEDULE
DUE DATE: Release 3.0