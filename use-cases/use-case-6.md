#USE CASE: 6 Produce a Report on the specific number of capital cities.
##CHARACTERISTIC INFORMATION
###Goal in Context
6. As a Data Analyst I want to receive reports on the population of a specific number of capital cities in the world, in a continent and in a region, provided by me, so that I can make a statistical report for the most populated capital city.

###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the field we are searching into - world, continent, region. Database contains information about the top N populated capital cities.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is produced.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

##MAIN SUCCESS SCENARIO
1.Organisation request information about the population of capital cities.
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of the top N populated capital cities for the given field .
4.Data Analyst provides report to the organisation.



##SCHEDULE
DUE DATE: Release 3.0