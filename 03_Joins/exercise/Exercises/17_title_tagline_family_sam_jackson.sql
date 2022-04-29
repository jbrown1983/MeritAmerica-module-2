-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)


SELECT title, tagline 
FROM movie 
JOIN movie_actor AS ma ON ma.movie_id = movie.movie_id 
JOIN person ON person_id = ma.actor_id 
JOIN movie_genre AS mg ON mg.movie_id = movie.movie_id 
JOIN genre ON genre.genre_id = mg.genre_id 
WHERE person_name = 'Samuel L. Jackson' AND genre_name = 'Family';
