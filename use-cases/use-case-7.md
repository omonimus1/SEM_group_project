#USE CASE: 7 Generate a Report on people
##CHARACTERISTIC INFORMATION
###Goal in Context
As a Data Analyst I want to generate reports on the number of people who live in the cities and who do not in the cities in each continent, in each region and in each country so that a comparison between living in a city and a village can be made.

###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the field given by continent - continent, region, country. Database contains data about the population of people leaving and not living in cities.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is generated.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

##MAIN SUCCESS SCENARIO
1.Organisation requests information about the population of people.
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of population of people, living and not living in cities in each field.
4.Data Analyst provides report to the organisation.

##EXTENSIONS
Field does not exist:
Data analyst informs the organisation that a field has not been filled yet.

##SUB-VARIATIONS
None.

##SCHEDULE
DUE DATE: Release 3.0