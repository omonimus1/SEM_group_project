#USE CASE: 7 Produce a Report on people
##CHARACTERISTIC INFORMATION
###Goal in Context
7. As a Data Analyst I want to receive reports on the number of people who live in the cities and who do not in the cities in each continent, in each region and in each country so that I can make a comparison between living in a city and a village.

###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the field given by continent - continent, region, country. Database contains data about the population of people leaving and not living in cities.

###Success End Condition
A report is available for the Data Analyst.

###Failed End Condition
No report is produced.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

##MAIN SUCCESS SCENARIO
1.Organisation request information about the population of people.
2.Data Analyst searches into each field given by the organisation.
3.Data Analyst extracts data of population of people, living and not living in cities in each field.
4.Data Analyst provides report to the organisation.



##SCHEDULE
DUE DATE: Release 3.0