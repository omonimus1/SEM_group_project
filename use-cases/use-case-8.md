#USE CASE: 8 Information about population to be accessible.
##CHARACTERISTIC INFORMATION
###Goal in Context
As a *development team* we would like to *receive the information about the population of the world, of a continent, of a region, of a country, of a district and of a city* so that *the data analysts can use the data for research and reports*.
###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the field given by organisation - world, continent, region, country, district, city. Database contains data about the population.

###Success End Condition
The info about population is accessible.

###Failed End Condition
Information is not accessible

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

###MAIN SUCCESS SCENARIO
1.Organisation request information about the population.
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of population of people in each field.
4.Data Analyst provides report to the organisation.


###EXTENSIONS
Field does not exist:
Data analyst informs the organisation that a field has not been filled yet.

###SUB-VARIATIONS
None.

###SCHEDULE
DUE DATE: Release 2.0