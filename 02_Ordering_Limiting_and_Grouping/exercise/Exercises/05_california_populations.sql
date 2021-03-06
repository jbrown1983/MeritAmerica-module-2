-- 5. The sum of the population of all cities in California. Name the column 'california_population'.
-- Expected answer is around 20,000,000
-- (1 row)

Select SUM(population) as california_population
From city
Where state_abbreviation IN ('CA');