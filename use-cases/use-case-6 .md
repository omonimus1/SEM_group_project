#USE CASE: 6 Generate a Report on the Specific Number of Capital Cities with the largest Population.
##CHARACTERISTIC INFORMATION
###Goal in Context
As a *Data Analyst* I want to *generate reports on the top X populated capital cities in the world, in a continent and in a region, where X is a number provided by me*, so that *a statistical report for the most populated capital city can be made*.
###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the field we are searching into - world, continent, region. Database contains information about the top N populated capital cities.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is generated.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

###MAIN SUCCESS SCENARIO
1.Organisation request information about the population of capital cities.
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of the top N populated capital cities for the given field .
4.Data Analyst provides report to the organisation.

###EXTENSIONS
Field does not exist:
Data analyst informs the organisation that a field has not been filled yet.

###SUB-VARIATIONS
None.

###SCHEDULE
DUE DATE: Release v0.1-alpha-3