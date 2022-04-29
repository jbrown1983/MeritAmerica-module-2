-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).


SELECT G.genre_name, COUNT(M.*) num_of_movies 
FROM movie M 
JOIN movie_genre MG ON M.movie_id = MG.movie_id 
JOIN genre G ON MG.genre_id = G.genre_id 
GROUP BY G.genre_name