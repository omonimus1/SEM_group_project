#USE CASE: 1 Generate a Report on the Countries in the World, Continents and Regions based on their Population
##CHARACTERISTIC INFORMATION
###Goal in Context
As a *Data Analyst* I want to *generate reports on the countries in the world, in a continent and in a region organised by population from the largest to the smallest* so that *the information can be used for research about population patterns*.
###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the field. Database contains data on population of the countries in the world, continents and regions and sorting them from largest to smallest.

###Success End Condition
A report is available for a statistician to complete his research.

###Failed End Condition
No report is generated.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

###MAIN SUCCESS SCENARIO
1.Organisation requests information for a given field - country, continent, regions.
2.Data Analyst gets the field to obtain information on the population.
3.Data Analyst extracts data of the population for the given field.
4.Data Analyst provides report to the organisation.

###EXTENSIONS
Order top populated countries:
Data analyst groups the top N populated countries in the given field.

###SUB-VARIATIONS
None

###SCHEDULE
DUE DATE: Release 2.0