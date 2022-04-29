-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
-- Hint: DISTINCT will prevent duplicate values in your query results.
--Person > Movie_Actor > Movie_Genre > Genre 

select distinct genre_name 
from genre
join movie_genre on genre.genre_id = movie_genre.genre_id
join movie on movie.movie_id = movie_genre.movie_id
join movie_actor on movie_actor.movie_id = movie.movie_id
join person on person.person_id = movie_actor.actor_id
where person_name ='Christopher Lloyd';
