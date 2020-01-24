# Software Engineering Methods(SEM) Group 9

- Master Build Status [![Build Status](https://travis-ci.org/omonimus1/SEM_group_project.svg?branch=master)](https://travis-ci.org/omonimus1/SEM_group_project)
- Develop Build Status [![Build Status](https://travis-ci.org/omonimus1/SEM_group_project.svg?branch=develop)](https://travis-ci.org/omonimus1/SEM_group_project)
- License [![LICENSE](https://img.shields.io/github/license/omonimus1/SEM_group_project.svg?style=flat-square)](https://github.com/omonimus1/SEM_group_project/blob/master/LICENSE)
- Release [![Releases](https://img.shields.io/github/release/omonimus1/SEM_group_project/all.svg?style=flat-square)](https://github.com/omonimus1/SEM_group_project/releases)

***

## Goal of the SEM assessment 

* Work in team using scrum methodology
* Apply modern software enginnering methods
* Use Github, Zum and other DevOps tools (as Docker and IntelliJ)

***

## Git workflow
[GitWorkflow](gitflow/gitflow-en.md)

***

## Assessment 

Having already a specific dataset (SQL data base), our task is to design and implement a new system that allow easy access to the population information (already stored in the our database). 

The organisation with who are we working with has asked for the following reports to be generated:

* All the countries in the world organised by largest population to smallest.
* All the countries in a continent organised by largest population to smallest.
* All the countries in a region organised by largest population to smallest.
* The top N populated countries in the world where N is provided by the user.
* The top N populated countries in a continent where N is provided by the user.
* The top N populated countries in a region where N is provided by the user.
* All the cities in the world organised by largest population to smallest.
* All the cities in a continent organised by largest population to smallest.
* All the cities in a region organised by largest population to smallest.
* All the cities in a country organised by largest population to smallest.
* All the cities in a district organised by largest population to smallest.
* The top N populated cities in the world where N is provided by the user.
* The top N populated cities in a continent where N is provided by the user.
* The top N populated cities in a region where N is provided by the user.
* The top N populated cities in a country where N is provided by the user.
* The top N populated cities in a district where N is provided by the user.
* All the capital cities in the world organised by largest population to smallest.
* All the capital cities in a continent organised by largest population to smallest.
* All the capital cities in a region organised by largest to smallest.
* The top N populated capital cities in the world where N is provided by the user.
* The top N populated capital cities in a continent where N is provided by the user.
* The top N populated capital cities in a region where N is provided by the user.
* The population of people, people living in cities, and people not living in cities in each continent.
* The population of people, people living in cities, and people not living in cities in each region.
* The population of people, people living in cities, and people not living in cities in each country.

Additionally, the organisation will be able to have access to the report 
The population of:
* The world.
* A continent.
* A region.
* A country.
* A district.
* A city.

Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:

* Chinese.
* English.
* Hindi.
* Spanish.
* Arabic.

### Country Report will the following columns:

* Code.
* Name.
* Continent.
* Region.
* Population.
* Capital.
* City Report

### City report will the following columns:

* Name.
* Country.
* District.
* Population.

### Capital City Report will the following columns:

* Name.
* Country.
* Population.

###  Population Report will the following columns:

* The name of the continent/region/country.
* The total population of the continent/region/country.
* The total population of the continent/region/country living in cities (including a %).
* The total population of the continent/region/country not living in cities (including a %).

***

### Contributors:

* Magdalena Calkova    : 40400974   @McPenquen
* Simona Georgieva     :            @SimonaGeorgieva99
* Simone Piazzini      : 40212394   @axis93
* Davide Pollicino     : 40401270   @omonimus1

***

### Marking sheet scheme

(marking sheet)[MarkingSheet/Markingsheet.docx]
