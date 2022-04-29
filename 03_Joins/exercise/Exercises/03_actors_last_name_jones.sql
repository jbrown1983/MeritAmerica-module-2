-- 3. For all actors with the last name of "Jones", 
--display the actor's name and movie titles they appeared in. 
--Order the results by the actor names (A-Z). (48 rows)




Select person_name, title
from person
join movie_actor on movie_actor.actor_id = person.person_id
join movie on  movie.movie_id = movie_actor.movie_id
Where person_name like '% Jones'
Order by person_name;

