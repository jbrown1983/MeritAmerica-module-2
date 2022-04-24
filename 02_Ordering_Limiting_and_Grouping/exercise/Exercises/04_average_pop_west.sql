-- 4. The average population of states in the "West" census region. Name the column 'average_population'.
-- Expected answer is around 6,000,000
-- (1 row)

Select AVG(population) as average_population
From state
Where census_region IN ('West');