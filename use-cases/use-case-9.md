#USE CASE: 8 Information about languages spoken to be accessible.
##CHARACTERISTIC INFORMATION
###Goal in Context
As a *development team* we would like to *provide the data analysts with information about the number of people who speak Spanish, English, Hindi, Arabic and Chinese in ascending order including the percentage of the world population* so that *it can be used for analysis about the most spoken language*.
###Scope
Organisation.

###Level
Primary task.

###Preconditions
We know the languages given by the organisation - Spanish, English, Hindi, Arabic, Chinese. The database contains the data about number of people speaking the given languages.

###Success End Condition
Info about languages spoken are accessible.

###Failed End Condition
Info is not accessible.

###Primary Actor
Data Analyst

###Trigger
A request for statistics information is sent to the Data Analyst.

###MAIN SUCCESS SCENARIO
1.Organisation request information about the languages spoken.
2.Data Analyst searches into the requested field to obtained the report.
3.Data Analyst extracts data of number of people who speak the requested language including the percentage of the world population.
4.Data Analyst provides report to the organisation.

###EXTENSIONS
Field does not exist:
Data analyst informs the organisation that a field has not been filled yet.

###SUB-VARIATIONS
None.

###SCHEDULE
DUE DATE: Release v0.1-alpha-3