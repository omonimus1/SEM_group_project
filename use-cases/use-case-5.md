#USE CASE: 5 Generate a Report on the Capital Cities based on their Population
##CHARACTERISTIC INFORMATION
###Goal in Context
As a *Data Analyst* I want to *generate reports on the capital cities in the world, in a continent and in a region organised by the population from the largest to the smallest* so that *they will be used on a research related to capital cities*.
###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the field we are searching into - world, continent, region. Database contains information about capital cities.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is produced.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

###MAIN SUCCESS SCENARIO
1.Organisation request information about capital cities.
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of the capital cities for the given field .
4.Data Analyst provides report to the organisation.

###EXTENSIONS
Generate a report of specific number of cities:
Data analyst performs a report for a specific number of cities.

###SUB-VARIATIONS
None.

###SCHEDULE
DUE DATE: Release 2.0