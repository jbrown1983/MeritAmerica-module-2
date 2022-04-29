-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)

select title, person_name
from movie_actor
join person on person.person_id = movie_actor.actor_id
join movie on movie.movie_id = movie_actor.movie_id
WHERE actor_id = director_id 