tables:
	city , country , countrylanguage

1)All the countries in the world organised by largest population to smallest.
SELECT Name
FROM country
ORDER BY Population DESC; 

2)All the countries in a continent organised by largest population to smallest.
/*Thinking that the user has choosen Asia a country: */
SELECT Name 
from country
WHERE Continent = 'Asia'
ORDER BY Population DESC;


3)All the countries in a region organised by largest population to smallest.
/*Supposing that the user has indicated Caribbean as region */
SELECT Name 
FROM country
WHERE Region = 'Caribbean' 
ORDER BY Population DESC; 


4)The top N populated countries in the world where N is provided by the user.
/*Supposing that N in this case is 5*/
SELECT Name
FROM country
ORDER BY Population DESC
LIMIT 5; 

5)TO FIX   ---- The top N populated countries in a continent where N is provided by the user.
/*Supposing that N in this case is 5 */
SELECT Name 
FROM country
ORDER BY Population DESC
GROUP BY Continent
LIMIT 5; 



6)The top N populated countries in a region where N is provided by the user.
/*Supposing that N in this case is 5*/


7)All the cities in the world organised by largest population to smallest.
SELECT Name
FROM city
ORDER BY Population DESC; 


8)All the cities in a continent organised by largest population to smallest.


9)All the cities in a region organised by largest population to smallest.
/* TO fix */


10)All the cities in a country organised by largest population to smallest.

11)All the cities in a district organised by largest population to smallest.
/* District: Colorado */
SELECT Name
FROM city
WHERE District = 'Colorado'
ORDER BY Population DESC; 

12)The top N populated cities in the world where N is provided by the user.
/*Supposing that N in this case is 5*/
SELECT Name
FROM city
ORDER BY Population DESC
LIMIT 5; 


13)The top N populated cities in a continent where N is provided by the user.
/*Supposing that N in this case is 5 */
SELECT Name , COUNT(*) 
FROM city
GROUP BY Continent; 


14)The top N populated cities in a region where N is provided by the user.
/*Supposing that N in this case is 5*/
15)The top N populated cities in a country where N is provided by the user.
/*Supposing that N in this case is 5*/
16)The top N populated cities in a district where N is provided by the user.
/*Supposing that N in this case is 5*/
17)All the capital cities in the world organised by largest population to smallest.
18)All the capital cities in a continent organised by largest population to smallest.
19)All the capital cities in a region organised by largest to smallest.

20)The top N populated capital cities in the world where N is provided by the user.
/*Supposing that N in this case is 5*/
SELECT city.Name 
FROM city
JOIN country ON city.ID = country.Capital
ORDER BY city.Population DESC
LIMIT 5;



21)The top N populated capital cities in a continent where N is provided by the user.
/*Supposing that N in this case is 5*/


22)The top N populated capital cities in a region where N is provided by the user.
/*Supposing that N in this case is 5*/
23)The population of people, people living in cities, and people not living in cities in each continent.
24)The population of people, people living in cities, and people not living in cities in each region.
25)The population of people, people living in cities, and people not living in cities in each country.
