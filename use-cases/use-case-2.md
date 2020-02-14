#USE CASE: 2 Generate a Report on the Top X Populated Countries
##CHARACTERISTIC INFORMATION
###Goal in Context
As a *Data Analyst* I want to *generate reports on the top X populated countries, where X is a number specified by me, in the world, in a continent and in a region*, so that *the statistic can be used in a further research about the top populated countries*.
###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the number of top populated countries to be searched. Database contains data for world, continent and region.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is generated.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

###MAIN SUCCESS SCENARIO
1.Organisation request information for a given field - country, continent, regions requesting the top N populated countries.
2.Data Analyst searches the top N populated countries, given by the organisation.
3.Data Analyst extracts data of the population for the given field and top countries.
4.Data Analyst provides report to the organisation.

###EXTENSIONS
Field does not exist:
Data analyst informs the organisation that a field has not been filled yet.

###SUB-VARIATIONS
None

###SCHEDULE
DUE DATE: Release 2.0