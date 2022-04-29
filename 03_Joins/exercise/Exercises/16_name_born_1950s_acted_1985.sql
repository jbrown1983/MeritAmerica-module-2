-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)

select person_name, birthday
from person
join movie_actor on person.person_id = movie_actor.actor_id
join movie on movie_actor.movie_id = movie.movie_id 
where release_date between '01-01-1985' and '12-31-1985'
AND birthday between '01-01-1950' and '12-31-1959' 
group by person_name, birthday
