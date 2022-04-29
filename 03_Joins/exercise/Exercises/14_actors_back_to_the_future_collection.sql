-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection" (28 rows)

select person_name
from  movie_actor
join person on person.person_id = movie_actor.actor_id
join movie on movie.movie_id = movie_actor.movie_id
join collection on collection.collection_id = movie.collection_id 
where collection.collection_name ='Back to the Future Collection'
group by person_name

